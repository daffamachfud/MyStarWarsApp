package com.onoh.mystarwarsapp.ui.starship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.ui.people.PeopleAdapter
import com.onoh.mystarwarsapp.ui.people.PeopleViewModel
import kotlinx.android.synthetic.main.activity_people.*
import kotlinx.android.synthetic.main.activity_people.progressBar
import kotlinx.android.synthetic.main.activity_starship.*

class StarshipActivity : AppCompatActivity() {

    private lateinit var adapter:StarshipAdapter
    private lateinit var viewModel: StarshipViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starship)
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[StarshipViewModel::class.java]
        adapter = StarshipAdapter()
        adapter.notifyDataSetChanged()
        rv_starship.layoutManager = LinearLayoutManager(this)
        rv_starship.adapter = adapter

        viewModel.getStarshipData(1)
        showLoading(true)
        subscribe()
    }

    private fun subscribe() {
        viewModel.setStarshipData().observe(this, {
            if(it!= null){
                val dummy = viewModel.getDummy()
                adapter.setStarship(it,dummy)
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
