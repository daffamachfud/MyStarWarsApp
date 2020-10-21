package com.onoh.mystarwarsapp.ui.film

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.FilmEntity
import com.onoh.mystarwarsapp.data.remote.response.FilmResponse
import com.onoh.mystarwarsapp.data.remote.result.FilmResult
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmViewModel:ViewModel() {
    val listFilm = MutableLiveData<ArrayList<FilmResult>>()

    internal fun getFilmData(page:Int){
        RetrofitClient.api().getFilms(page).enqueue(object : Callback<FilmResponse> {
            override fun onResponse(call: Call<FilmResponse>, response: Response<FilmResponse>) {
                if (response.isSuccessful) {
                    val listFilmResult = response.body()?.results
                    listFilm.postValue(listFilmResult as ArrayList<FilmResult>?)
                }
            }
            override fun onFailure(call: Call<FilmResponse>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setFilmData(): LiveData<ArrayList<FilmResult>> {
        return listFilm
    }

    fun getDummyFilm():List<FilmEntity> = DataDummy.generateDummyFilm()
}