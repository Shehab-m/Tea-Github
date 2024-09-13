package com.teacomputers.teagithub.presentation.navigation

sealed class Screens(val route: String) {
    data object AuthScreen : Screens("authScreen")
    data object ReposScreen : Screens("reposScreen")
    data object SplashScreen : Screens("splashScreen")
}