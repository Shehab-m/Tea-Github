package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.domain.usecase.GetAccessTokenLocalUseCase
import com.teacomputers.teagithub.domain.usecase.GetAccessTokenUseCase
import com.teacomputers.teagithub.domain.usecase.GetReposUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val usecaseModule = module {
    singleOf(::GetAccessTokenUseCase).bind<GetAccessTokenUseCase>()
    single<GetReposUseCase> { GetReposUseCase(get()) }
    single<GetAccessTokenLocalUseCase> { GetAccessTokenLocalUseCase(get()) }
}