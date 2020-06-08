package com.resocoder.forecastmvvm.data.network

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.resocoder.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.resocoder.forecastmvvm.data.network.response.FutureWeatherResponse
import com.resocoder.forecastmvvm.data.network.response.NewCurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY="112f36ed71533e0fb9e689574e189d35"
//http://api.weatherstack.com/current?access_key=112f36ed71533e0fb9e689574e189d35&query=london

//http://api.apixu.com/v1/current.json?key=89e8bd89085b41b7a4b142029180210&q=London&lang=en
//https://api.apixu.com/v1/forecast.json?key=89e8bd89085b41b7a4b142029180210&q=Los%20Angeles&days=1

interface ApixuWeatherApiService {
    @GET("current")
    fun getCurrentWeather(
            @Query("q") location: String = "London",
            @Query("lang") languageCode: String = "en"
//                    Log.d("weather=>>>>>>","------------.toString()")
    ): Deferred<NewCurrentWeatherResponse>

    @GET("future.json")
    fun getFutureWeather(
            @Query("q") location: String="London",
            @Query("days") days: Int=1,
            @Query("lang") languageCode: String = "en"
    ): Deferred<FutureWeatherResponse>
//    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(
                connectivityInterceptor: ConnectivityInterceptor
        ): ApixuWeatherApiService {
            Log.d("NewCurrentweather","<<<<<<<<------------.toString()")
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("access_key", API_KEY)
                        .build()
                Log.d("NewCurrentweather","<<<<<<<<------------.toString()")
                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                Log.d("Currentweather","request-URL="+request.toString())

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .addInterceptor(connectivityInterceptor)
                    .build()
                    Log.d("NewCurrentweather","<<<<<<<<------------.toString()")

            return Retrofit.Builder()
                    .client(okHttpClient)
//                .baseUrl("https://api.apixu.com/v1/")
//                    .baseUrl("http://api.weatherstack.com/")
                    .baseUrl("http://15.223.48.136/myapi/current/newweather.php/")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApixuWeatherApiService::class.java)

        }
    }
}