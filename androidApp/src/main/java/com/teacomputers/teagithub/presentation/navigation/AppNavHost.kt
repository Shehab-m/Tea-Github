package com.teacomputers.teagithub.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost() {
    val navController = LocalNavigationProvider.current
    NavHost(
        navController = navController,
        startDestination = Graph.APP
    ) {
        appNavGraph()
    }
}

object Graph {
    const val APP = "app_graph"
}