package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.presentation.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AuthViewModel()
    }

}