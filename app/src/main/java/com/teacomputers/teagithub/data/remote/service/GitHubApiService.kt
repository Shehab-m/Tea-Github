package com.teacomputers.teagithub.data.remote.service

import com.teacomputers.teagithub.BuildConfig
import com.teacomputers.teagithub.data.remote.model.AccessTokenDto
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GitHubApiService {

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("code") code: String,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
    ): Response<AccessTokenDto>

}