package com.teacomputers.teagithub.presentation.navigation

sealed class Screens(val route: String) {
    data object AuthScreen : Screens("authScreen")
}