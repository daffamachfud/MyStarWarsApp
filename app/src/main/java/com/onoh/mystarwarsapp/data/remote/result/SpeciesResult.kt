package com.onoh.mystarwarsapp.data.remote.result

import com.google.gson.annotations.SerializedName

data class SpeciesResult(
    @field:SerializedName("name")
    val name : String,

    @field:SerializedName("classification")
    val classification : String,

    @field:SerializedName("designation")
    val designation : String,

    @field:SerializedName("average_height")
    val average_height : String,

    @field:SerializedName("skin_colors")
    val skin_colors : String,

    @field:SerializedName("hair_colors")
    val hair_colors : String,

    @field:SerializedName("eye_colors")
    val eye_colors : String,

    @field:SerializedName("average_lifespan")
    val average_lifespan : String,

    @field:SerializedName("homeworld")
    val homeworld : String,

    @field:SerializedName("language")
    val language : String,

    @field:SerializedName("people")
    val people : List<String>,

    @field:SerializedName("films")
    val films : List<String>,

    @field:SerializedName("created")
    val created : String,

    @field:SerializedName("edited")
    val edited : String,

    @field:SerializedName("url")
    val url : String
)