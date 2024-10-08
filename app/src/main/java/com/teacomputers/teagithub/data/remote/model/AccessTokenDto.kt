package com.teacomputers.teagithub.data.remote.model

import com.google.gson.annotations.SerializedName

data class AccessTokenDto (
    @SerializedName("access_token")
    val accessToken: String?,
    @SerializedName("token_type")
    val tokenType: String?,
    @SerializedName("scope")
    val scope: String?
)
