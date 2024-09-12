package com.teacomputers.teagithub.domain.repository

interface GithubRepository {
    suspend fun getAccessToken(code: String): String
}