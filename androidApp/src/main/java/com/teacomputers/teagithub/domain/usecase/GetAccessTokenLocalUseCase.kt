package com.teacomputers.teagithub.domain.usecase

import com.teacomputers.teagithub.domain.repository.GithubRepository

class GetAccessTokenLocalUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(): String? {
        return repository.getAccessTokenLocal()
    }

}