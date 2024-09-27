package com.teacomputers.teagithub.data.repository.mapper

import com.teacomputers.teagithub.data.remote.model.OwnerDto
import com.teacomputers.teagithub.domain.model.Owner

fun OwnerDto.toEntity(): Owner {
    return Owner(
        avatarUrl = avatarUrl ?: "",
        id = id ?: 0
    )
}
