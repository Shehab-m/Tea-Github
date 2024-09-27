package com.teacomputers.teagithub.presentation.manager

import android.content.Intent
import android.net.Uri
import android.util.Log
import com.teacomputers.teagithub.BuildConfig

class OAuthManagerImpl: OAuthManager {

    override fun getOAuthIntent(): Intent {
        val clientId = BuildConfig.CLIENT_ID
        val githubAuthUrl = buildString {
            append("https://github.com/login/oauth/authorize")
            append("?client_id=${clientId}")
            append("&scope=user,repo")
            append("&redirect_uri=$REDIRECT_URI")
        }
        return Intent(Intent.ACTION_VIEW, Uri.parse(githubAuthUrl)).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }


    override fun onOAuthCallback(intent: Intent): String? {
        val uri = intent.data ?: return null
        if (!uri.toString().startsWith(REDIRECT_URI)) return null
        val authorizationCode = uri.getQueryParameter("code")
        Log.d("OAuth Callback", "Authorization code received: $authorizationCode")
        return authorizationCode
    }

    companion object {
        private const val REDIRECT_URI = "teagithub://callback"
    }
}
