package com.gadidev.sportaldi.model

import com.google.gson.annotations.SerializedName

data class Events (
        @field:SerializedName("events")
        val events: List<ListEvents>,

        @field:SerializedName("event")
        val event: List<ListEvents>,
)


data class ListEvents (

        @field:SerializedName("idLeague")
        val idLeague: String,

        @field:SerializedName("idEvent")
        val idEvent: String,

        @field:SerializedName("idAPIfootball")
        val idAPIfootball: String,

        @field:SerializedName("strLeague")
        val strLeague: String,

        @field:SerializedName("idHomeTeam")
        val idHomeTeam: String,

        @field:SerializedName("strHomeTeam")
        val strHomeTeam: String,

        @field:SerializedName("idAwayTeam")
        val idAwayTeam: String,

        @field:SerializedName("strAwayTeam")
        val strAwayTeam: String,

        @field:SerializedName("intHomeScore")
        val intHomeScore: String,

        @field:SerializedName("intAwayScore")
        val intAwayScore: String,

        @field:SerializedName("dateEvent")
        val dateEvent: String,

        @field:SerializedName("strTime")
        val strTime: String,

        @field:SerializedName("strVenue")
        val strVenue: String,

        @field:SerializedName("strHomeYellowCards")
        val strHomeYellowCards: String,

        @field:SerializedName("strAwayYellowCards")
        val strAwayYellowCards: String,

        @field:SerializedName("strHomeRedCards")
        val strHomeRedCards: String,

        @field:SerializedName("strAwayRedCards")
        val strAwayRedCards: String,

        @field:SerializedName("intHomeShots")
        val intHomeShots: String,

        @field:SerializedName("intAwayShots")
        val intAwayShots: String,

        @field:SerializedName("strHomeFormation")
        val strHomeFormation: String,

        @field:SerializedName("strAwayFormation")
        val strAwayFormation: String,

        @field:SerializedName("strHomeGoalDetails")
        val strHomeGoalDetails: String,

        @field:SerializedName("strAwayGoalDetails")
        val strAwayGoalDetails: String,

        @field:SerializedName("strDescriptionEN")
        val strDescriptionEN: String,
        )
