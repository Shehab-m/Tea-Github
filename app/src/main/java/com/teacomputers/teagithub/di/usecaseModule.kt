package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.domain.usecase.GetAccessTokenLocalUseCase
import com.teacomputers.teagithub.domain.usecase.GetAccessTokenUseCase
import com.teacomputers.teagithub.domain.usecase.GetReposUseCase
import org.koin.dsl.module

val usecaseModule = module {
    single<GetAccessTokenUseCase> { GetAccessTokenUseCase(get()) }
    single<GetReposUseCase> { GetReposUseCase(get()) }
    single<GetAccessTokenLocalUseCase> { GetAccessTokenLocalUseCase(get()) }
}