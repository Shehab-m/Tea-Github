package com.teacomputers.teagithub.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.teacomputers.teagithub.presentation.auth.authRoute

fun NavGraphBuilder.authNavGraph() {
    navigation(
        startDestination = Screens.AuthScreen.route,
        route = Graph.AUTH
    ) {
        authRoute()
    }
}