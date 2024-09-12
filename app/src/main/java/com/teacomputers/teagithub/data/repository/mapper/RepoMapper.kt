package com.teacomputers.teagithub.data.repository.mapper

import com.teacomputers.teagithub.data.remote.model.RepoDto
import com.teacomputers.teagithub.domain.model.License
import com.teacomputers.teagithub.domain.model.Owner
import com.teacomputers.teagithub.domain.model.Repo


fun RepoDto.toEntity(): Repo {
    return Repo(
        id = id ?: 0,
        createdAt = createdAt ?: "",
        defaultBranch = defaultBranch ?: "",
        description = description ?: "",
        language = language ?: "",
        license = license?.toEntity() ?: License("", ""),
        name = name ?: "",
        owner = owner?.toEntity() ?: Owner("", 0),
        private = private ?: false
    )
}
