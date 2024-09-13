package com.teacomputers.teagithub.presentation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.teacomputers.teagithub.presentation.navigation.Screens

private val ROUTE = Screens.AuthScreen.route

fun NavController.navigateToAuthScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.authRoute() {
    composable(ROUTE) {
        AuthScreen()
    }
}