package com.teacomputers.teagithub.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.teacomputers.teagithub.presentation.splash.splashRoute

fun NavGraphBuilder.splashNavGraph() {
    navigation(
        startDestination = Screens.SplashScreen.route,
        route = Graph.SPLASH
    ) {
        splashRoute()
    }
}