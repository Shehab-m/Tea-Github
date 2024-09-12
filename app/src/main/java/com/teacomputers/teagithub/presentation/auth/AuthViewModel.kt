package com.teacomputers.teagithub.presentation.auth

import android.content.Intent
import android.util.Log
import com.teacomputers.teagithub.domain.usecase.GetAccessTokenUseCase
import com.teacomputers.teagithub.presentation.base.BaseViewModel
import com.teacomputers.teagithub.presentation.manager.OAuthManager

class AuthViewModel(
    private val oAuthManager: OAuthManager,
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
) : BaseViewModel<AuthUiState, AuthUiEffect>(AuthUiState()), AuthInteractionListener {

    override fun onClickLogin() {
        val intent = oAuthManager.getOAuthIntent()
        sendEffect(AuthUiEffect.HandleOauthIntent(intent))
    }

    fun onOAuthCallback(intent: Intent) {
        val code = oAuthManager.onOAuthCallback(intent)
        val accessToken = getAccessToken(code)
        Log.d("onOAuthCallback: ", "$accessToken")
    }

    private fun getAccessToken(code: String?) {
        updateState { it.copy(isLoading = true) }
        tryToExecute(
            { getAccessTokenUseCase(code) },
            ::onSuccessGetAccessToken,
            ::onError
        )
    }

    private fun onSuccessGetAccessToken(accessToken: String) {
        Log.d("onSuccessGetAccessToken: ", accessToken)
        sendEffect(AuthUiEffect.NavigateToReposScreen(accessToken))
    }

    private fun onError(error: Exception) {
        updateState { it.copy(isLoading = false) }
        Log.e("onError: ", "${error.message}")
        sendEffect(AuthUiEffect.SendToast("Something went wrong. Please try again."))
    }

}