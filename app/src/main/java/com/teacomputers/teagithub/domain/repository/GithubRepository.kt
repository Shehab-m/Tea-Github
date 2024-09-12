package com.teacomputers.teagithub.domain.repository

interface GithubRepository {
    suspend fun getAccessToken(clientId: String, code: String): String
}