package com.resocoder.forecastmvvm.data.network.Response2


import com.google.gson.annotations.SerializedName

data class NewFutureWeatherResponse(
    val forecast: Forecast,
    val location: Location
)