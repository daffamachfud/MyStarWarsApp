package com.onoh.mystarwarsapp.network

import com.onoh.mystarwarsapp.data.remote.response.*
import com.onoh.mystarwarsapp.data.remote.result.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    fun getCharacter(@Query("page") page:Int): Call<PeopleResponse>

    @GET("people/{id}")
    fun getCharacterDetail(@Path("id") id:Int): Call<PeopleResult>

    @GET("films/")
    fun getFilms(@Query("page") page:Int): Call<FilmResponse>

    @GET("films/{id}")
    fun getFilmDetail(@Path("id") id:Int): Call<FilmResult>

    @GET("starships/")
    fun getStarships(@Query("page")page:Int): Call<StartshipResponse>

    @GET("starships/{id}")
    fun getStarshipDetail(@Path("id") id:Int): Call<StarshipResult>

    @GET("vehicles/")
    fun getVehicles(@Query("page") page:Int): Call<VehicleResponse>

    @GET("vehicles/{id}")
    fun getDetailVehicle(@Path("id") id:Int): Call<VehicleResult>

    @GET("species/")
    fun getSpecies(@Query("page") page:Int): Call<SpeciesResponse>

    @GET("species/{id}")
    fun getDetailSpecies(@Path("id") id:Int): Call<SpeciesResult>

    @GET("planets/")
    fun getPlanet(@Query("page") page:Int): Call<PlanetResponse>

    @GET("planets/{id}")
    fun getDetailPlanet(@Path("id") id:Int): Call<PlanetResult>

}