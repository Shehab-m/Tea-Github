package com.teacomputers.teagithub.presentation.splash

import com.teacomputers.teagithub.presentation.base.BaseUiEffect

sealed interface SplashUiEffect : BaseUiEffect {
    data class NavigateToReposScreen(val accessToken: String): SplashUiEffect
    data object NavigateToAuthScreen: SplashUiEffect
}