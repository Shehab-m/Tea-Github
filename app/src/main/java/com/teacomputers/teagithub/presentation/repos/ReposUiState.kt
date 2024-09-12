package com.teacomputers.teagithub.presentation.repos

import com.teacomputers.teagithub.domain.model.Owner
import com.teacomputers.teagithub.domain.model.Repo

data class ReposUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val repos: List<RepoUIState> = emptyList()
)

data class RepoUIState(
    val id: Int = 0,
    val createdAt: String = "",
    val defaultBranch: String = "",
    val language: String = "",
    val name: String = "",
    val owner: OwnerUIState = OwnerUIState(),
    val private: Boolean = false,
)

data class OwnerUIState(
    val id: Int = 0,
    val avatarUrl: String = "",
)

fun Repo.toUIState(): RepoUIState {
    return RepoUIState(
        id = id,
        createdAt = createdAt.substringBefore('T'),
        defaultBranch = defaultBranch,
        language = language,
        name = name,
        owner = owner.toUIState(),
        private = private
    )
}

fun Owner.toUIState(): OwnerUIState {
    return OwnerUIState(
        id = id,
        avatarUrl = avatarUrl
    )
}
