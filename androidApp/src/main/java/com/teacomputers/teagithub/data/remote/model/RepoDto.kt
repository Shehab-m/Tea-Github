package com.teacomputers.teagithub.data.remote.model

import com.google.gson.annotations.SerializedName

data class RepoDto(
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("default_branch")
    val defaultBranch: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("forks_count")
    val forksCount: Int?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("license")
    val license: LicenseDto?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("owner")
    val owner: OwnerDto?,
    @SerializedName("private")
    val private: Boolean?,
)