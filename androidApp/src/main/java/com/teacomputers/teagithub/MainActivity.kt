package com.teacomputers.teagithub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.teacomputers.shared.App
import com.teacomputers.teagithub.presentation.auth.AuthViewModel
import com.teacomputers.teagithub.presentation.navigation.AppNavHost
import com.teacomputers.teagithub.presentation.navigation.LocalNavigationProvider
import com.teacomputers.teagithub.ui.theme.TeaGithubTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val authViewModel by viewModel<AuthViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
                TeaGithubTheme {
//                    Scaffold(modifier = Modifier.fillMaxSize()) {
//                        AppNavHost()
//                    }
                    App()
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val data = intent.data
        if (data != null && data.scheme == "teagithub" && data.host == "callback") {
            authViewModel.onOAuthCallback(intent)
        }
    }
}