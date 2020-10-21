package com.onoh.mystarwarsapp.data.remote.result

import com.google.gson.annotations.SerializedName

data class PlanetResult(
    @field:SerializedName("name")
    val name : String?=null,

    @field:SerializedName("rotation_period")
    val rotation_period : String?=null,

    @field:SerializedName("orbital_period")
    val orbital_period : String?=null,

    @field:SerializedName("diameter")
    val diameter : String?=null,

    @field:SerializedName("climate")
    val climate : String?=null,

    @field:SerializedName("gravity")
    val gravity : String?=null,

    @field:SerializedName("terrain")
    val terrain : String?=null,

    @field:SerializedName("surface_water")
    val surface_water : String?=null,

    @field:SerializedName("population")
    val population : String?=null,

    @field:SerializedName("residents")
    val residents : List<String>?=null,

    @field:SerializedName("films")
    val films : List<String>?=null,

    @field:SerializedName("created")
    val created : String?=null,

    @field:SerializedName("edited")
    val edited : String?=null,

    @field:SerializedName("url")
    val url : String?=null
)