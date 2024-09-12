package com.teacomputers.teagithub.di

import androidx.lifecycle.SavedStateHandle
import com.teacomputers.teagithub.presentation.auth.AuthViewModel
import com.teacomputers.teagithub.presentation.repos.ReposViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AuthViewModel(get(), get())
    }
    viewModel { (handle: SavedStateHandle) ->
        ReposViewModel(get(), handle)
    }
}