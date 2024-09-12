package com.teacomputers.teagithub.presentation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.teacomputers.teagithub.presentation.navigation.Screens

private val ROUTE = Screens.AuthScreen.route

fun NavGraphBuilder.authRoute() {
    composable(ROUTE) {
        AuthScreen()
    }
}