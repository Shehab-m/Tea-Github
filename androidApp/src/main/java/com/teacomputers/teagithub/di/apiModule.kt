package com.teacomputers.teagithub.di

import com.teacomputers.teagithub.data.remote.RequestInterceptor
import com.teacomputers.teagithub.data.remote.service.GitHubApiService
import com.teacomputers.teagithub.data.remote.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { provideGson() }
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofitBuilder(get(),get()) }
    single { provideRetrofitService(get()) }
}

fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor,
): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(RequestInterceptor())
        .build()
}

fun provideRetrofitBuilder(
    client: OkHttpClient,
    factory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(client)
        .addConverterFactory(factory)
        .build()
}

fun provideRetrofitService(retrofit: Retrofit): GitHubApiService {
    return retrofit.create(GitHubApiService::class.java)
}