package com.gadidev.sportaldi.model

import com.google.gson.annotations.SerializedName

data class League(

    @field:SerializedName("leagues")
    val leagues: List<ListLeague>,

)
   data class ListLeague (

        @field:SerializedName("idLeague")
        val idLeague: String,

        @field:SerializedName("strLeague")
        val strLeague: String,

        @field:SerializedName("strSport")
        val strSport: String,
    )

