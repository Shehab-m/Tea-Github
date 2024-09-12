package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.presentation.auth.AuthViewModel
import com.teacomputers.teagithub.presentation.manager.OAuthManager
import com.teacomputers.teagithub.presentation.manager.OAuthManagerImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AuthViewModel(get())
    }
    single<OAuthManager> {
        OAuthManagerImpl()
    }
}