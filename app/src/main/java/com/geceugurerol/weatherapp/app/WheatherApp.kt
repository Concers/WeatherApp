package com.geceugurerol.weatherapp.app

import android.app.Application
import com.geceugurerol.weatherapp.di.applicationModule
import com.geceugurerol.weatherapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WheatherApp : Application() {
    override fun onCreate() {
        super.onCreate()



        startKoin {
            androidContext(this@WheatherApp)
            modules(
                listOf(
                    applicationModule,
                    viewModelModule
                )

            )
        }
    }
}