package com.geceugurerol.weatherapp.data.network.api

import com.geceugurerol.weatherapp.data.network.response.WheatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("weather?appid=bfd2878dbb0d32f150f347596064a220")
    suspend fun getWheatherCityName(
        @Query("q") cityName: String,
        @Query("units") unit: String
    ): WheatherResponse


}