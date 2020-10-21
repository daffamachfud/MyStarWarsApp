package com.onoh.mystarwarsapp.network

import com.onoh.mystarwarsapp.data.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    fun getCharacter(@Query("page") page:Int): Call<PeopleResponse>

    @GET("films/")
    fun getFilms(@Query("page") page:Int): Call<FilmResponse>

    @GET("starships/?pages2")
    fun getStarships(@Query("page")page:Int): Call<StartshipResponse>

    @GET("vehicles/")
    fun getVehicles(@Query("page") page:Int): Call<VehicleResponse>

    @GET("species/")
    fun getSpecies(@Query("page") page:Int): Call<SpeciesResponse>

    @GET("planets/")
    fun getPlanet(@Query("page") page:Int): Call<PlanetResponse>

}