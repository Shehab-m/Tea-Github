package com.teacomputers.teagithub.domain.model

data class Repo(
    val id: Int,
    val createdAt: String,
    val defaultBranch: String,
    val description: String,
    val language: String,
    val license: License,
    val name: String,
    val owner: Owner,
    val private: Boolean,
)