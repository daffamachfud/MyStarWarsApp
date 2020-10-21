package com.onoh.mystarwarsapp.data.remote.response

import com.google.gson.annotations.SerializedName
import com.onoh.mystarwarsapp.data.remote.result.VehicleResult

data class VehicleResponse(
    @field:SerializedName("count")
    val count : Int,

    @field:SerializedName("next")
    val next : String,

    @field:SerializedName("previous")
    val previous : String,

    @field:SerializedName("results")
    val results : List<VehicleResult>
)