package com.teacomputers.teagithub.domain.usecase

import com.teacomputers.teagithub.domain.repository.GithubRepository

class GetAccessTokenUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(code: String): String {
        return repository.getAccessToken(code)
    }

}