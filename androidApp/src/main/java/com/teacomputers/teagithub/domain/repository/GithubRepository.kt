package com.teacomputers.teagithub.domain.repository

import com.teacomputers.teagithub.domain.model.Repo

interface GithubRepository {
    suspend fun getAccessToken(code: String): String
    suspend fun getRepos(token: String): List<Repo>
    suspend fun getAccessTokenLocal(): String?
    suspend fun saveAccessTokenLocal(token: String)
}