package com.teacomputers.teagithub.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teacomputers.teagithub.domain.usecase.GetAccessTokenLocalUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

class SplashViewModel(private val getAccessTokenLocalUseCase: GetAccessTokenLocalUseCase) :
    ViewModel() {

    private val _effect = MutableSharedFlow<SplashUiEffect>()
    val effect = _effect.asSharedFlow().mapNotNull { it }

    init {
        checkNavigationDestination()
    }

    private fun checkNavigationDestination() {
        viewModelScope.launch {
            val accessToken = getAccessTokenLocalUseCase()
            delay(2500)
            accessToken?.let { token ->
                _effect.emit(SplashUiEffect.NavigateToReposScreen(token))
            } ?: _effect.emit(SplashUiEffect.NavigateToAuthScreen)
        }
    }
}