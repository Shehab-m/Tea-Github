package com.teacomputers.teagithub.presentation.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.teacomputers.teagithub.presentation.navigation.Screens

private val ROUTE = Screens.SplashScreen.route

fun NavGraphBuilder.splashRoute() {
    composable(ROUTE) {
        SplashScreen()
    }
}