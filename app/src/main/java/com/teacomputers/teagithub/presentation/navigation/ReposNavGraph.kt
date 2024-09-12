package com.teacomputers.teagithub.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.teacomputers.teagithub.presentation.repos.reposRoute

fun NavGraphBuilder.reposNavGraph() {
    navigation(
        startDestination = Screens.ReposScreen.route,
        route = Graph.REPOS
    ) {
        reposRoute()
    }
}