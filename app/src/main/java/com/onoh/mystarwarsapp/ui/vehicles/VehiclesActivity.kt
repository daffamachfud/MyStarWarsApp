package com.onoh.mystarwarsapp.ui.vehicles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.ui.starship.StarshipAdapter
import com.onoh.mystarwarsapp.ui.starship.StarshipViewModel
import kotlinx.android.synthetic.main.activity_people.*
import kotlinx.android.synthetic.main.activity_starship.*
import kotlinx.android.synthetic.main.activity_starship.progressBar
import kotlinx.android.synthetic.main.activity_vehicles.*

class VehiclesActivity : AppCompatActivity() {

    private lateinit var adapter: VehiclesAdapter
    private lateinit var viewModel: VehiclesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[VehiclesViewModel::class.java]
        adapter = VehiclesAdapter()
        adapter.notifyDataSetChanged()
        rv_vehicles.layoutManager = LinearLayoutManager(this)
        rv_vehicles.adapter = adapter

        viewModel.getVehiclesData(1)
        showLoading(true)
        subscribe()
    }

    private fun subscribe() {
        viewModel.setVehiclesData().observe(this, {
            if(it!= null){
                val dummy = viewModel.getDummy()
                adapter.setVehicles(it,dummy)
                showLoading(false)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}
