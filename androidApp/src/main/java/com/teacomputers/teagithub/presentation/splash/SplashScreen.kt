package com.teacomputers.teagithub.presentation.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacomputers.teagithub.R
import com.teacomputers.teagithub.presentation.auth.navigateToAuthScreen
import com.teacomputers.teagithub.presentation.base.EventHandler
import com.teacomputers.teagithub.presentation.repos.navigateToReposScreen
import com.teacomputers.teagithub.ui.theme.TeaGithubTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(viewModel: SplashViewModel = koinViewModel()) {
    EventHandler(effect = viewModel.effect) { effect, navController ->
        when (effect) {
            SplashUiEffect.NavigateToAuthScreen -> {
                navController.navigateToAuthScreen()
            }

            is SplashUiEffect.NavigateToReposScreen -> {
                navController.navigateToReposScreen(effect.accessToken)
            }
        }
    }
    SplashContent()
}

@Composable
fun SplashContent() {
    val iconAlpha = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        iconAlpha.animateTo(1f, animationSpec = tween(1500))
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(280.dp).alpha(iconAlpha.value),
            painter = painterResource(id = R.drawable.github_logo),
            contentDescription = stringResource(R.string.splash_icon),
            tint = MaterialTheme.colorScheme.background
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    TeaGithubTheme {
        SplashContent()
    }
}
