package com.teacomputers.teagithub.presentation.repos

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.teacomputers.teagithub.domain.model.Repo
import com.teacomputers.teagithub.domain.usecase.GetReposUseCase
import com.teacomputers.teagithub.presentation.base.BaseViewModel

class ReposViewModel(
    private val getReposUseCase: GetReposUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ReposUiState, ReposUiEffect>(ReposUiState()), ReposInteractionListener {

    private val accessToken = ReposArgs(savedStateHandle).accessToken

    init {
        getRepos(accessToken)
    }

    private fun getRepos(accessToken: String?) {
        updateState { it.copy(isError = false, isLoading = true) }
        tryToExecute(
            { getReposUseCase(accessToken) },
            ::onSuccessGetRepos,
            ::onError
        )
    }

    private fun onSuccessGetRepos(repos: List<Repo>) {
        updateState { it.copy(isLoading = false, repos = repos.map { it.toUIState() }) }
    }

    private fun onError(error: Exception) {
        Log.e("onError: ", "${error.message}")
        updateState { it.copy(isError = true, isLoading = false) }
        sendEffect(ReposUiEffect.SendToast("Something went wrong. Please try again."))
    }

    override fun onClickTryAgain() {
        getRepos(accessToken)
    }
}