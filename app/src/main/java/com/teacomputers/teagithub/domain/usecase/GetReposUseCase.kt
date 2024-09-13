package com.teacomputers.teagithub.domain.usecase

import com.teacomputers.teagithub.domain.model.Repo
import com.teacomputers.teagithub.domain.repository.GithubRepository

class GetReposUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(token: String): List<Repo> {
        return repository.getRepos(token)
    }

}