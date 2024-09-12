package com.teacomputers.teagithub.data.repository

import android.util.Log
import com.teacomputers.teagithub.data.remote.service.GitHubApiService
import com.teacomputers.teagithub.domain.repository.GithubRepository
import retrofit2.Response

class GithubRepositoryImpl(private val apiService: GitHubApiService): GithubRepository {

    override suspend fun getAccessToken(clientId: String, code: String): String {
        return wrapResponse{apiService.getAccessToken(clientId,code)}.accessToken ?: ""
    }

    private suspend fun <T> wrapResponse(
        function: suspend () -> Response<T>
    ): T {
        return try {
            val apiResponse = function()
            if (apiResponse.isSuccessful) {
                val responseBody = apiResponse.body()
                Log.d("Tag", "response Success: $responseBody")
                responseBody ?: throw Exception("Data not found!")
            } else {
                val message = apiResponse.message()
                Log.d("Tag", "response Not Success:: $message")
                throw Exception(message)
            }
        } catch (e: Exception) {
            Log.e("Tag", "response Error:${e.message}")
            throw Exception("${e.message}")
        }
    }
}