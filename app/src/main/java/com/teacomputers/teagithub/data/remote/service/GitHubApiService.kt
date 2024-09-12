package com.teacomputers.teagithub.data.remote.service

import com.teacomputers.teagithub.BuildConfig
import com.teacomputers.teagithub.data.remote.model.AccessTokenDto
import com.teacomputers.teagithub.data.remote.model.RepoDto
import com.teacomputers.teagithub.data.remote.utils.Constants
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url

interface GitHubApiService {

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    suspend fun getAccessToken(
        @Field("code") code: String,
        @Field("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
    ): Response<AccessTokenDto>

    @GET
    suspend fun getRepos(
        @Header("Authorization") token: String,
        @Url url: String = Constants.URL_REPOS
    ): Response<List<RepoDto>>
}