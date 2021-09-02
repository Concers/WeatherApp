package com.geceugurerol.weatherapp.data.network.response

import com.geceugurerol.weatherapp.data.model.*

data class WheatherResponse(
    val coord: CoordModel,
    val weather: List<WeatherModel>,
    val base: String,
    val main: MainModel,
    val visibility: Long,
    val wind: WindModel,
    val clouds: CloudsModel,
    val dt: Long,
    val sys: SysModel,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int,


    ) {
}