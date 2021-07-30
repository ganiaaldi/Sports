package com.gadidev.sportaldi.services

import com.gadidev.sportaldi.model.League
import retrofit2.Call
import retrofit2.http.GET

    interface ApiService {
        @GET("all_leagues.php")
            fun getAllLeagues() : Call<League>
//        fun getForecast(
//            @Query("q") cityName : String,
//            @Query("appid") apiKey : String,
//            @Query("units") units : String,
//        ) : Call<Weather>
    }