package com.teacomputers.teagithub.presentation.manager

import android.content.Intent

interface OAuthManager {
    fun getOAuthIntent(): Intent
    fun onOAuthCallback(intent: Intent): String?
}