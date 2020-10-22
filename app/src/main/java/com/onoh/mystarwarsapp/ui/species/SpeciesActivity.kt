package com.onoh.mystarwarsapp.ui.species

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.mystarwarsapp.R
import kotlinx.android.synthetic.main.activity_species.*
import kotlinx.android.synthetic.main.activity_starship.progressBar

class SpeciesActivity : AppCompatActivity() {

    private lateinit var adapter: SpeciesAdapter
    private lateinit var viewModel: SpeciesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_species)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[SpeciesViewModel::class.java]
        adapter = SpeciesAdapter()
        adapter.notifyDataSetChanged()
        rv_species.layoutManager = LinearLayoutManager(this)
        rv_species.adapter = adapter

        viewModel.getSpeciesData(1)
        showLoading(true)
        subscribe()
    }

    private fun subscribe() {
        viewModel.setSpeciesData().observe(this, {
            if(it!= null){
                val dummy = viewModel.getDummy()
                adapter.setSpecies(it,dummy)
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
