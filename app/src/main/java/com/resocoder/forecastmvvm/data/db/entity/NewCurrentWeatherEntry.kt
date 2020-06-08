package com.resocoder.forecastmvvm.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val NEW_CURRENT_WEATHER_ID = 0

@Entity(tableName = "new_current_weather")
data class NewCurrentWeatherEntry(
        @SerializedName("temp_c")
        val tempC: Double,
        @SerializedName("temp_f")
        val tempF: Double,
        @SerializedName("is_day")
        val isDay: Int,
        @Embedded(prefix = "condition_")
        val condition: Condition,
        @SerializedName("wind_mph")
        val windMph: Double,
        @SerializedName("wind_kph")
        val windKph: Double,
        @SerializedName("wind_dir")
        val windDir: String,
        @SerializedName("precip_mm")
        val precipMm: Double,
        @SerializedName("precip_in")
        val precipIn: Double,
        @SerializedName("feelslike_c")
        val feelslikeC: Double,
        @SerializedName("feelslike_f")
        val feelslikeF: Double,
        @SerializedName("vis_km")
        val visKm: Double,
        @SerializedName("vis_miles")
        val visMiles: Double
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = NEW_CURRENT_WEATHER_ID
}