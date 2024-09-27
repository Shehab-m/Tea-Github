package com.teacomputers.teagithub.data.remote.model

import com.google.gson.annotations.SerializedName

data class LicenseDto(
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?,
)