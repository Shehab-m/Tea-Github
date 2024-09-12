package com.teacomputers.teagithub.presentation.repos

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.teacomputers.teagithub.ui.theme.TeaGithubTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ReposScreen(viewModel: ReposViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    ReposContent(state, viewModel)
}

@Composable
fun ReposContent(
    state: ReposUiState, listener: ReposInteractionListener
) {

}

@Composable
@Preview
fun ReposScreenPreview() {
    TeaGithubTheme {
        ReposContent(
            state = ReposUiState(),
            listener = object : ReposInteractionListener {

            }
        )
    }
}
