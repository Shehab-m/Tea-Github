package com.teacomputers.teagithub.presentation.repos

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.teacomputers.teagithub.presentation.navigation.Screens

private val ROUTE = Screens.ReposScreen.route

fun NavController.navigateToReposScreen(accessToken: String?) {
    navigate("$ROUTE/$accessToken") {
        popUpTo(graph.startDestinationId) {
            inclusive = true
        }
        launchSingleTop = true
    }
}

fun NavGraphBuilder.reposRoute() {
    composable(
        route = "${ROUTE}/{${ReposArgs.ACCESS_TOKEN}}",
        arguments = listOf(
            navArgument(ReposArgs.ACCESS_TOKEN) {
                type = NavType.StringType
            }
        )
    ) {
        ReposScreen()
    }
}

class ReposArgs(savedStateHandle: SavedStateHandle) {
    val accessToken: String = checkNotNull(savedStateHandle[ACCESS_TOKEN])

    companion object {
        const val ACCESS_TOKEN = "accessToken"
    }
}
