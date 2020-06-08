package com.resocoder.forecastmvvm.data.network.Response2


import com.google.gson.annotations.SerializedName

data class Location(
    val country: String,
    val lat: String,
    val localtime: String,
    @SerializedName("Localtime_epoch")
    val localtimeEpoch: String,
    val lon: String,
    val name: String,
    val region: String,
    @SerializedName("tz_id")
    val tzId: String
)