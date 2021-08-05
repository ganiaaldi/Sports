package com.gadidev.sportaldi.services

import com.gadidev.sportaldi.model.Events
import com.gadidev.sportaldi.model.League
import com.gadidev.sportaldi.model.LeagueDetail
import com.gadidev.sportaldi.model.Teams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("all_leagues.php")
            fun getAllLeagues() : Call<League>

        @GET("lookupleague.php")
        fun getDetailLeague(
                @Query("id") id : String,
        ) : Call<LeagueDetail>


        @GET("eventspastleague.php")
        fun getEventPast(
                @Query("id") id: String
        ) : Call <Events>

        @GET("eventsseason.php")
        fun getNextEvents(
                @Query("id") id: String,
                @Query("s") seasons: String
        ) : Call <Events>

        @GET("lookupevent.php")
        fun getDetailEvents(
                @Query("id") id: String
        ) : Call <Events>

        @GET("lookupteam.php")
        fun getTeams(
                @Query("id") id: String
        ) : Call <Teams>

        @GET("searchevents.php")
        fun searchEvents(
                @Query("e") e: String
        ) : Call <Events>
    }