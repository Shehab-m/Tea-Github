package com.teacomputers.teagithub.data.remote.service

import com.teacomputers.teagithub.BuildConfig
import com.teacomputers.teagithub.data.remote.model.AccessTokenDto
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface GitHubApiService {

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    suspend fun getAccessToken(
        @Field("code") code: String,
        @Field("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
    ): Response<AccessTokenDto>

}