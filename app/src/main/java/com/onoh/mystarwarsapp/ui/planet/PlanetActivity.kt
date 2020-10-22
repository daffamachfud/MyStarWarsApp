package com.onoh.mystarwarsapp.ui.planet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.mystarwarsapp.R
import kotlinx.android.synthetic.main.activity_planet.*
import kotlinx.android.synthetic.main.activity_species.progressBar

class PlanetActivity : AppCompatActivity() {
    private lateinit var adapter: PlanetAdapter
    private lateinit var viewModel: PlanetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[PlanetViewModel::class.java]
        adapter = PlanetAdapter()
        adapter.notifyDataSetChanged()
        rv_planet.layoutManager = LinearLayoutManager(this)
        rv_planet.adapter = adapter

        viewModel.getPlanetData(1)
        showLoading(true)
        subscribe()
    }

    private fun subscribe() {
        viewModel.setPlanetData().observe(this, {
            if(it!= null){
                val dummy = viewModel.getDummy()
                adapter.setPlanet(it,dummy)
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
