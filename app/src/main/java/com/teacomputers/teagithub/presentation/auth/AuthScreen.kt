package com.teacomputers.teagithub.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacomputers.teagithub.R
import com.teacomputers.teagithub.presentation.base.EventHandler
import com.teacomputers.teagithub.presentation.composable.Loading
import com.teacomputers.teagithub.presentation.composable.TAnimationContent
import com.teacomputers.teagithub.presentation.composable.TFilledButton
import com.teacomputers.teagithub.ui.theme.TeaGithubTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun AuthScreen(viewModel: AuthViewModel = getViewModel<AuthViewModel>()) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    EventHandler(viewModel.effect) { effect, navController ->
        when(effect) {
            is AuthUiEffect.HandleOauthIntent -> {
                context.startActivity(effect.intent)
            }
        }
    }
    AuthContent(state, viewModel)
}

@Composable
fun AuthContent(
    state: AuthUiState, listener: AuthInteractionListener
) {
    Scaffold { innerPadding ->
        TAnimationContent(
            state = state.isLoading,
            content = {
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 36.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.github_logo),
                            contentDescription = "Github Icon",
                            modifier = Modifier.size(56.dp),
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = stringResource(R.string.welcome_to_github),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.secondary,
                        )
                    }
                    TFilledButton(
                        label = stringResource(R.string.login),
                        onClick = listener::onClickLogin,
                        textStyle = MaterialTheme.typography.labelLarge
                    )
                }
            },
            loadingContent = { Loading(state = state.isLoading) },
            isError = state.isError,
        )
    }
}

@Composable
@Preview
fun AuthScreenPreview() {
    TeaGithubTheme {
        AuthContent(
            state = AuthUiState(),
            listener = object : AuthInteractionListener {
                override fun onClickLogin() {}
            }
        )
    }
}
