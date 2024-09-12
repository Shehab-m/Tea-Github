package com.teacomputers.teagithub.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost() {
    val navController = LocalNavigationProvider.current
    NavHost(
        navController = navController,
        startDestination = Graph.AUTH
    ) {
        authNavGraph()
        reposNavGraph()
    }
}

object Graph {
    const val AUTH = "auth_graph"
    const val REPOS = "repos_graph"
}