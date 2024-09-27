package com.teacomputers.teagithub.data.repository.mapper

import com.teacomputers.teagithub.data.remote.model.LicenseDto
import com.teacomputers.teagithub.domain.model.License

fun LicenseDto.toEntity(): License {
    return License(
        key = key ?: "",
        name = name ?: ""
    )
}
