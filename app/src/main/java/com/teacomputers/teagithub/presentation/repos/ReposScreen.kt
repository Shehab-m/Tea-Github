package com.teacomputers.teagithub.presentation.repos

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacomputers.teagithub.R
import com.teacomputers.teagithub.presentation.base.EventHandler
import com.teacomputers.teagithub.presentation.composable.Loading
import com.teacomputers.teagithub.presentation.composable.TAnimationContent
import com.teacomputers.teagithub.presentation.composable.TTopBar
import com.teacomputers.teagithub.presentation.repos.composable.ItemRepo
import com.teacomputers.teagithub.ui.theme.TeaGithubTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ReposScreen(viewModel: ReposViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    EventHandler(viewModel.effect) { effect, navController ->
        when(effect) {
            is ReposUiEffect.SendToast -> {
                Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
            }
        }
    }
    ReposContent(state, viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReposContent(
    state: ReposUiState, listener: ReposInteractionListener
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            TTopBar(
                title = "Your Repositories",
                icon = painterResource(id = R.drawable.github_logo),
                iconColor = MaterialTheme.colorScheme.secondary
            )
            TAnimationContent(
                state = state.isLoading,
                content = {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(horizontal = 20.dp),
                    ) {
                        items(state.repos) { repo ->
                            ItemRepo(
                                modifier = Modifier,
                                repo = repo,
                            )
                        }
                    }
                },
                loadingContent = { Loading(state = true) },
                isError = state.isError,
                onClickTryAgain = {
                    listener.onClickTryAgain()
                }
            )
        }
    }
}

@Composable
@Preview
fun ReposScreenPreview() {
    TeaGithubTheme {
        ReposContent(
            state = ReposUiState(),
            listener = object : ReposInteractionListener {
                override fun onClickTryAgain() {}
            }
        )
    }
}
