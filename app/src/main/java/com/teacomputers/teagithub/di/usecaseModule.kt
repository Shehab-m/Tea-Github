package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.domain.usecase.GetAccessTokenUseCase
import org.koin.dsl.module

val usecaseModule = module {
    single<GetAccessTokenUseCase> { GetAccessTokenUseCase(get()) }
}