package com.teacomputers.teagithub.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.teacomputers.teagithub.presentation.auth.authRoute
import com.teacomputers.teagithub.presentation.repos.reposRoute
import com.teacomputers.teagithub.presentation.splash.splashRoute

fun NavGraphBuilder.appNavGraph() {
    navigation(
        startDestination = Screens.SplashScreen.route,
        route = Graph.APP
    ) {
        authRoute()
        reposRoute()
        splashRoute()
    }
}