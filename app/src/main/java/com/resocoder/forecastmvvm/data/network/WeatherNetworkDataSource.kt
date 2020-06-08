package com.resocoder.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import com.resocoder.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.resocoder.forecastmvvm.data.network.response.FutureWeatherResponse
import com.resocoder.forecastmvvm.data.network.response.NewCurrentWeatherResponse


interface WeatherNetworkDataSource {
//    val downloadedCurrentWeather: LiveData<NewCurrentWeatherResponse>
    val downloadedCurrentWeather: LiveData<NewCurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}