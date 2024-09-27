package com.teacomputers.teagithub.data.local

interface AuthPreferences {
    suspend fun getAccessToken(): String?
    suspend fun saveAccessToken(token: String)
    suspend fun clearAccessToken()
}