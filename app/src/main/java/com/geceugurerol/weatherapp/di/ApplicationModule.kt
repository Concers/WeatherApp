package com.geceugurerol.weatherapp.di


import android.os.Build
import android.view.textclassifier.TextSelection
import androidx.viewbinding.BuildConfig
import com.geceugurerol.weatherapp.data.network.api.WeatherAPIService
import com.geceugurerol.weatherapp.data.repository.WeatherRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

inline fun <reified T> createApiInstance(retrofit: Retrofit): T = retrofit.create(T::class.java)

val applicationModule = module {
    single { getRetrofit() }

    factory { createApiInstance<WeatherAPIService>(get()) }
    single { WeatherRepository(get()) }
}