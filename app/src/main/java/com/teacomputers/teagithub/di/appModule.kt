package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.data.local.AuthPreferences
import com.teacomputers.teagithub.data.local.AuthPreferencesImp
import com.teacomputers.teagithub.data.remote.RequestInterceptor
import com.teacomputers.teagithub.data.repository.GithubRepositoryImpl
import com.teacomputers.teagithub.domain.repository.GithubRepository
import com.teacomputers.teagithub.presentation.auth.AuthViewModel
import com.teacomputers.teagithub.presentation.manager.OAuthManager
import com.teacomputers.teagithub.presentation.manager.OAuthManagerImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AuthViewModel(get(), get())
    }
    single<OAuthManager> {
        OAuthManagerImpl()
    }
    single<GithubRepository> {
        GithubRepositoryImpl(get(),get())
    }
    single<AuthPreferences> {
        AuthPreferencesImp(get())
    }
    single<RequestInterceptor> {
        RequestInterceptor()
    }
}