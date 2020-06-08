package com.resocoder.forecastmvvm.data.network.response


import com.resocoder.forecastmvvm.data.db.entity.NewCurrentWeatherEntry
import com.resocoder.forecastmvvm.data.db.entity.NewWeatherLocation

data class NewCurrentWeatherResponse(
        val newCurrentWeatherEntry: NewCurrentWeatherEntry,
        val newWeatherLocation: NewWeatherLocation,
        val request: Request
)