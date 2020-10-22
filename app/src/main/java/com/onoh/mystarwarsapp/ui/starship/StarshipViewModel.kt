package com.onoh.mystarwarsapp.ui.starship

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.StarshipEntity
import com.onoh.mystarwarsapp.data.remote.response.StartshipResponse
import com.onoh.mystarwarsapp.data.remote.result.StarshipResult
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipViewModel :ViewModel() {
    val listStarship = MutableLiveData<ArrayList<StarshipResult>>()

    internal fun getStarshipData(page:Int){
        RetrofitClient.api().getStarships(page).enqueue(object : Callback<StartshipResponse> {
            override fun onResponse(call: Call<StartshipResponse>, response: Response<StartshipResponse>) {
                if (response.isSuccessful) {
                    val listResult = response.body()?.results
                    listStarship.postValue(listResult as ArrayList<StarshipResult>?)
                }
            }
            override fun onFailure(call: Call<StartshipResponse>, t: Throwable) {
                Log.d("onFailured", t.message.toString())
            }
        })
    }

    internal fun setStarshipData(): LiveData<ArrayList<StarshipResult>>{
        return listStarship
    }

    fun getDummy():List<StarshipEntity> = DataDummy.generateDummyStarship()
}