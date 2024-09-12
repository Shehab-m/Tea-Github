package com.teacomputers.teagithub.presentation.manager

import android.content.Intent
import android.net.Uri
import android.util.Log

class OAuthManagerImpl: OAuthManager {

    override fun getOAuthIntent(): Intent {
        val githubAuthUrl = buildString {
            append("https://github.com/login/oauth/authorize")
            append("?client_id=$CLIENT_ID")
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
        private const val CLIENT_ID = "Ov23lii4TTZ2ByTwNyzo"
        private const val REDIRECT_URI = "teagithub://callback"
    }
}
