package com.onoh.mystarwarsapp.ui.species

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.SpeciesEntity
import com.onoh.mystarwarsapp.data.remote.response.PeopleResponse
import com.onoh.mystarwarsapp.data.remote.response.SpeciesResponse
import com.onoh.mystarwarsapp.data.remote.response.StartshipResponse
import com.onoh.mystarwarsapp.data.remote.result.PeopleResult
import com.onoh.mystarwarsapp.data.remote.result.SpeciesResult
import com.onoh.mystarwarsapp.data.remote.result.StarshipResult
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeciesViewModel :ViewModel() {
    val listSpecies = MutableLiveData<ArrayList<SpeciesResult>>()

    internal fun getSpeciesData(page:Int){
        RetrofitClient.api().getSpecies(page).enqueue(object : Callback<SpeciesResponse> {
            override fun onResponse(call: Call<SpeciesResponse>, response: Response<SpeciesResponse>) {
                if (response.isSuccessful) {
                    val listResult = response.body()?.results
                    listSpecies.postValue(listResult as ArrayList<SpeciesResult>?)
                }
            }
            override fun onFailure(call: Call<SpeciesResponse>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setSpeciesData(): LiveData<ArrayList<SpeciesResult>>{
        return listSpecies
    }

    fun getDummy():List<SpeciesEntity> = DataDummy.generateDummySpecies()
}