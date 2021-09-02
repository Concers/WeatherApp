package com.geceugurerol.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geceugurerol.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val mutableFeelsLike = MutableLiveData<String>()
    private val mutableWindspeed = MutableLiveData<String>()
    private val mutableCloudsAll = MutableLiveData<String>()

    val feelLike: LiveData<String>
        get() = mutableFeelsLike
    val windspeed: LiveData<String>
        get() = mutableWindspeed
    val cloudsAll : LiveData<String>
        get() = mutableCloudsAll


    private val mutableErrorWeatherByCityNameResponse = MutableLiveData<String>()
    val errorWeatherByCityNameResponse: LiveData<String>
        get() = mutableErrorWeatherByCityNameResponse



    fun getWeatherByCityName(cityname: String, unit: String) {
        viewModelScope.launch {
            try {
                val weatherByCityNameResponse =
                    weatherRepository.getWeatherByCityName(cityname, unit)

                with(weatherByCityNameResponse){
                    main.feels_like.let {
                        mutableFeelsLike.value = it.toString()
                    }
                    wind.speed.let {
                        mutableWindspeed.value = it.toString()
                    }
                    clouds.all.also {
                        mutableCloudsAll.value = it.toString()
                    }
                }

            } catch (exception: Exception) {
                mutableErrorWeatherByCityNameResponse.value = exception.message
            }

        }


    }


}