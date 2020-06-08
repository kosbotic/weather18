package com.resocoder.forecastmvvm.data.network.Response2


import com.google.gson.annotations.SerializedName

data class Forecastday(
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val day: Day
)