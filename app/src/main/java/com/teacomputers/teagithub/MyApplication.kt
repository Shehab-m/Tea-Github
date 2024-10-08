package com.teacomputers.teagithub

import android.app.Application
import com.teacomputers.teagithub.di.apiModule
import com.teacomputers.teagithub.di.appModule
import com.teacomputers.teagithub.di.usecaseModule
import com.teacomputers.teagithub.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, apiModule, usecaseModule, viewModelModule)
        }
    }
}