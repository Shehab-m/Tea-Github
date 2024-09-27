package com.teacomputers.teagithub.presentation.repos

import com.teacomputers.teagithub.presentation.base.BaseUiEffect

sealed interface ReposUiEffect : BaseUiEffect {
    data class SendToast(val message: String): ReposUiEffect
}