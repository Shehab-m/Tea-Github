package com.teacomputers.teagithub.presentation.auth

import android.content.Intent
import android.util.Log
import com.teacomputers.teagithub.presentation.base.BaseViewModel
import com.teacomputers.teagithub.presentation.manager.OAuthManager

class AuthViewModel(
    private val oAuthManager: OAuthManager
) : BaseViewModel<AuthUiState, AuthUiEffect>(AuthUiState()),
    AuthInteractionListener {

    override fun onClickLogin() {
        val intent = oAuthManager.getOAuthIntent()
        sendEffect(AuthUiEffect.HandleOauthIntent(intent))
    }

    fun onOAuthCallback(intent: Intent) {
        val code = oAuthManager.onOAuthCallback(intent)
    }

}