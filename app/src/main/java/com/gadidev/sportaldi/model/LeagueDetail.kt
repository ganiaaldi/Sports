package com.gadidev.sportaldi.model

import com.google.gson.annotations.SerializedName

data class LeagueDetail (
        @field:SerializedName("leagues")
        val leagues: List<LeagueDetails>,
        )


data class LeagueDetails (

        @field:SerializedName("idLeague")
        val idLeague: String,

        @field:SerializedName("strLeague")
        val strLeague: String,

        @field:SerializedName("strBadge")
        val strBadge: String,

        @field:SerializedName("strCurrentSeason")
        val strCurrentSeason: String,

        @field:SerializedName("strWebsite")
        val strWebsite: String,

)
