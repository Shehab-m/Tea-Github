package com.teacomputers.teagithub.domain.usecase

import com.teacomputers.teagithub.domain.model.Repo
import com.teacomputers.teagithub.domain.repository.GithubRepository

class GetReposUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(token: String? = null): List<Repo> {
        val accessToken = token ?: repository.getAccessTokenLocal()
        val repos = repository.getRepos(accessToken ?: "")
        return repos
    }

}