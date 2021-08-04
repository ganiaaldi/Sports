package com.gadidev.sportaldi.model

import com.google.gson.annotations.SerializedName

data class Teams (
        @field:SerializedName("teams")
        val teams: List<TeamsDetail>,
)


data class TeamsDetail (

        @field:SerializedName("idTeam")
        val idTeam: String,

        @field:SerializedName("strTeam")
        val strTeam: String,

        @field:SerializedName("strTeamBadge")
        val strTeamBadge: String
)
