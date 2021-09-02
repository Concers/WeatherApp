package com.geceugurerol.weatherapp.data.repository

import com.geceugurerol.weatherapp.data.network.api.WeatherAPIService
import com.geceugurerol.weatherapp.data.network.response.WheatherResponse

class WeatherRepository(private var weatherApiService: WeatherAPIService) {
    suspend fun getWeatherByCityName(
        cityname: String,
        unit: String,
    ): WheatherResponse = weatherApiService.getWheatherCityName(cityname, unit)


}