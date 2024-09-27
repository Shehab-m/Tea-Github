package com.teacomputers.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform