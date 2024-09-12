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
        popUpTo(ROUTE) {
            inclusive = true
        }
        popBackStack()
    }
}


fun NavGraphBuilder.reposRoute() {
    composable(
        route = "${ROUTE}/{${ReposArgs.ACCESS_TOKEN}}",
        arguments = listOf(
            navArgument(ReposArgs.ACCESS_TOKEN) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )
    ) {
        ReposScreen()
    }
}

class ReposArgs(savedStateHandle: SavedStateHandle) {
    val accessToken: String? = savedStateHandle[ACCESS_TOKEN]

    companion object {
        const val ACCESS_TOKEN = "accessToken"
    }
}
