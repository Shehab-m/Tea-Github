package com.teacomputers.teagithub.presentation.auth

import android.content.Intent
import com.teacomputers.teagithub.presentation.base.BaseUiEffect

sealed interface AuthUiEffect : BaseUiEffect {
    data class HandleOauthIntent(val intent: Intent): AuthUiEffect
    data class SendToast(val message: String): AuthUiEffect
    data class NavigateToReposScreen(val accessToken: String): AuthUiEffect
}