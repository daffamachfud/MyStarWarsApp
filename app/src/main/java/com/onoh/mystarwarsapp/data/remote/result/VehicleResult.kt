package com.onoh.mystarwarsapp.data.remote.result

import com.google.gson.annotations.SerializedName

data class VehicleResult(
    @field:SerializedName("name") val name : String,
    @field:SerializedName("model") val model : String,
    @field:SerializedName("manufacturer") val manufacturer : String,
    @field:SerializedName("cost_in_credits") val cost_in_credits : String,
    @field:SerializedName("length") val length : String,
    @field:SerializedName("max_atmosphering_speed") val max_atmosphering_speed : String,
    @field:SerializedName("crew") val crew : String,
    @field:SerializedName("passengers") val passengers : String,
    @field:SerializedName("cargo_capacity") val cargo_capacity : String,
    @field:SerializedName("consumables") val consumables : String,
    @field:SerializedName("vehicle_class") val vehicle_class : String,
    @field:SerializedName("pilots") val pilots : List<String>,
    @field:SerializedName("films") val films : List<String>,
    @field:SerializedName("created") val created : String,
    @field:SerializedName("edited") val edited : String,
    @field:SerializedName("url") val url : String
)