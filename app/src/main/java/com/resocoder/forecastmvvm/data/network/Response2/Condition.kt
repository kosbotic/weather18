package com.resocoder.forecastmvvm.data.network.Response2


import com.google.gson.annotations.SerializedName

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)