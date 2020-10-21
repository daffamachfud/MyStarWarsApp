package com.onoh.mystarwarsapp.ui.planet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.PlanetEntity
import com.onoh.mystarwarsapp.data.remote.response.PeopleResponse
import com.onoh.mystarwarsapp.data.remote.response.PlanetResponse
import com.onoh.mystarwarsapp.data.remote.response.SpeciesResponse
import com.onoh.mystarwarsapp.data.remote.response.StartshipResponse
import com.onoh.mystarwarsapp.data.remote.result.PeopleResult
import com.onoh.mystarwarsapp.data.remote.result.PlanetResult
import com.onoh.mystarwarsapp.data.remote.result.SpeciesResult
import com.onoh.mystarwarsapp.data.remote.result.StarshipResult
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetViewModel :ViewModel() {
    val listPlanet = MutableLiveData<ArrayList<PlanetResult>>()

    internal fun getPlanetData(page:Int){
        RetrofitClient.api().getPlanet(page).enqueue(object : Callback<PlanetResponse> {
            override fun onResponse(call: Call<PlanetResponse>, response: Response<PlanetResponse>) {
                if (response.isSuccessful) {
                    val listResult = response.body()?.results
                    listPlanet.postValue(listResult as ArrayList<PlanetResult>?)
                }
            }
            override fun onFailure(call: Call<PlanetResponse>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setPlanetData(): LiveData<ArrayList<PlanetResult>>{
        return listPlanet
    }

    fun getDummy():List<PlanetEntity> = DataDummy.generateDummyPlanet()
}