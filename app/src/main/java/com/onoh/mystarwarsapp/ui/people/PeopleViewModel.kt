package com.onoh.mystarwarsapp.ui.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.PeopleEntity
import com.onoh.mystarwarsapp.data.remote.response.PeopleResponse
import com.onoh.mystarwarsapp.data.remote.result.PeopleResult
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleViewModel :ViewModel() {
    val listPeople = MutableLiveData<ArrayList<PeopleResult>>()

    internal fun getPeopleData(page:Int){
        RetrofitClient.api().getCharacter(page).enqueue(object : Callback<PeopleResponse> {
            override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
                if (response.isSuccessful) {
                    val listUser = response.body()?.results
                    listPeople.postValue(listUser as ArrayList<PeopleResult>?)
                }
            }
            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setPeopleData(): LiveData<ArrayList<PeopleResult>>{
        return listPeople
    }

    fun getDummyFilm():List<PeopleEntity> = DataDummy.generateDummyPeople()
}