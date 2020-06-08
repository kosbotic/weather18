package com.resocoder.forecastmvvm.data.network.Response2


import com.google.gson.annotations.SerializedName

data class Forecast(
    val forecastday: List<Forecastday>
)