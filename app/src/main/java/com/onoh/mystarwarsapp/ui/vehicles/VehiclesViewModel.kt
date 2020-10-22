package com.onoh.mystarwarsapp.ui.vehicles

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.VehiclesEntity
import com.onoh.mystarwarsapp.data.remote.response.VehicleResponse
import com.onoh.mystarwarsapp.data.remote.result.VehicleResult
import com.onoh.mystarwarsapp.network.RetrofitClient
import com.onoh.mystarwarsapp.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehiclesViewModel :ViewModel() {
    val listVehicles = MutableLiveData<ArrayList<VehicleResult>>()

    internal fun getVehiclesData(page:Int){
        RetrofitClient.api().getVehicles(page).enqueue(object : Callback<VehicleResponse> {
            override fun onResponse(call: Call<VehicleResponse>, response: Response<VehicleResponse>) {
                if (response.isSuccessful) {
                    val listResult = response.body()?.results
                    listVehicles.postValue(listResult as ArrayList<VehicleResult>?)
                }
            }
            override fun onFailure(call: Call<VehicleResponse>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }

    internal fun setVehiclesData(): LiveData<ArrayList<VehicleResult>>{
        return listVehicles
    }

    fun getDummy():List<VehiclesEntity> = DataDummy.generateDummyVehicles()
}