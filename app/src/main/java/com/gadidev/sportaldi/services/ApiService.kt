package com.gadidev.sportaldi.services

import com.gadidev.sportaldi.model.Events
import com.gadidev.sportaldi.model.League
import com.gadidev.sportaldi.model.LeagueDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("all_leagues.php")
            fun getAllLeagues() : Call<League>

        @GET("lookupleague.php")
        fun getDetailLeague(
                @Query("id") idLeague : String,
        ) : Call<LeagueDetail>


        @GET("eventspastleague.php")
        fun getEventPast(
                @Query("id") idLeague: String
        ) : Call <Events>

        @GET("eventsseason.php")
        fun getNextEvents(
                @Query("id") idLeague: String,
                @Query("s") seasons: String
        ) : Call <Events>
    }