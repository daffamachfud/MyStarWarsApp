package com.onoh.mystarwarsapp.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.FilmEntity
import com.onoh.mystarwarsapp.data.local.PeopleEntity
import com.onoh.mystarwarsapp.data.local.SpeciesEntity
import com.onoh.mystarwarsapp.data.local.StarshipEntity
import com.onoh.mystarwarsapp.data.remote.result.*
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {
    val listPeople = MutableLiveData<DetailPeopleResult>()
    val listFilm = MutableLiveData<DetailFilmResult>()
    val listStarship = MutableLiveData<DetailStarshipResult>()
    val listSpecies = MutableLiveData<DetailSpeciesResult>()

    private lateinit var peopleId:String
    private lateinit var filmId:String
    private lateinit var starshipId:String
    private lateinit var speciesId:String

    internal fun getPeopleData(id:Int){
        RetrofitClient.api().getCharacterDetail(id).enqueue(object : Callback<PeopleResult> {
            override fun onResponse(call: Call<PeopleResult>, response: Response<PeopleResult>) {
                if (response.isSuccessful) {
                    val name = response.body()?.name
                    val gender = response.body()?.gender
                    val birth = response.body()?.birthYear
                    val height = response.body()?.height
                    val mass = response.body()?.mass
                    val detail = DetailPeopleResult(name,gender,birth,height,mass)
                    listPeople.postValue(detail)
                }
            }
            override fun onFailure(call: Call<PeopleResult>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setPeopleData(): LiveData<DetailPeopleResult> {
        return listPeople
    }


    //detail dummy people
    internal fun setSelectedPeople(peopleId:String){
        this.peopleId = peopleId
    }

    fun getDummyPeopleData():PeopleEntity{
        lateinit var people:PeopleEntity
        val peopleEntities = DataDummy.generateDummyPeople()
        for(peopleEntity in peopleEntities){
            if(peopleEntity.id == peopleId){
                people = peopleEntity
            }
        }
        return people
    }

    //DETAIL FILM
    internal fun getFilmData(id:Int){
        RetrofitClient.api().getFilmDetail(id).enqueue(object : Callback<FilmResult> {
            override fun onResponse(call: Call<FilmResult>, response: Response<FilmResult>) {
                if (response.isSuccessful) {
                    val title = response.body()?.title
                    val director = response.body()?.director
                    val producer = response.body()?.producer
                    val releaseDate = response.body()?.releaseDate
                    val crawl = response.body()?.openingCrawl
                    val detail = DetailFilmResult(title,crawl,director,producer,releaseDate)
                    listFilm.postValue(detail)
                }
            }
            override fun onFailure(call: Call<FilmResult>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setDetailFilm(): LiveData<DetailFilmResult> {
        return listFilm
    }


    //detail dummy people
    internal fun setSelectedFilmDummy(filmId:String){
        this.filmId = filmId
    }

    fun getDummyFilmData():FilmEntity{
        lateinit var filmDetail:FilmEntity
        val filmEntities = DataDummy.generateDummyFilm()
        for(filmEntity in filmEntities){
            if(filmEntity.id == filmId){
                filmDetail = filmEntity
            }
        }
        return filmDetail
    }

    //DETAIL STARSHIP
    internal fun getStarshipData(id:Int){
        RetrofitClient.api().getStarshipDetail(id).enqueue(object : Callback<StarshipResult> {
            override fun onResponse(call: Call<StarshipResult>, response: Response<StarshipResult>) {
                if (response.isSuccessful) {
                        val name = response.body()?.name
                        val model = response.body()?.model
                        val manufacture = response.body()?.manufacturer
                        val length = response.body()?.length
                        val passenger = response.body()?.passengers
                        val cargo = response.body()?.cargo_capacity
                        val detail = DetailStarshipResult(name, model, manufacture, length, passenger,cargo)
                        listStarship.postValue(detail)
                }else{
                    listStarship.postValue(null)
                }
            }
            override fun onFailure(call: Call<StarshipResult>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setDetailStarship(): LiveData<DetailStarshipResult> {
        return listStarship
    }


    //detail dummy people
    internal fun setSelectedStarshipDummy(starshipId:String){
        this.starshipId = starshipId
    }

    fun getDummyStarshipData():StarshipEntity{
        lateinit var startship:StarshipEntity
        val starshipEntities = DataDummy.generateDummyStarship()
        for(starshipEntity in starshipEntities){
            if(starshipEntity.id == starshipId){
                startship = starshipEntity
            }
        }
        return startship
    }

    //DETAIL SPECIES
    internal fun getSpeciesData(id:Int){
        RetrofitClient.api().getDetailSpecies(id).enqueue(object : Callback<SpeciesResult> {
            override fun onResponse(call: Call<SpeciesResult>, response: Response<SpeciesResult>) {
                if (response.isSuccessful) {
                    val name = response.body()?.name
                    val classification = response.body()?.classification
                    val designation = response.body()?.designation
                    val language = response.body()?.language
                    val detail = DetailSpeciesResult(name, classification, designation,language)
                    listSpecies.postValue(detail)
            }}
            override fun onFailure(call: Call<SpeciesResult>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setDetailSpecies(): LiveData<DetailSpeciesResult> {
        return listSpecies
    }


    //detail dummy people
    internal fun setSelectedSpeciesDummy(speciesId:String){
        this.speciesId = speciesId
    }

    fun getDummySpeciesData():SpeciesEntity{
        lateinit var species:SpeciesEntity
        val speciesEntities = DataDummy.generateDummySpecies()
        for(speciesEntity in speciesEntities){
            if(speciesEntity.id == speciesId){
                species = speciesEntity
            }
        }
        return species
    }

}