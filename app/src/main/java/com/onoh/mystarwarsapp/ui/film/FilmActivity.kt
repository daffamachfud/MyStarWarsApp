package com.onoh.mystarwarsapp.ui.film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.mystarwarsapp.R
import kotlinx.android.synthetic.main.activity_film.*
import kotlinx.android.synthetic.main.activity_people.progressBar

class FilmActivity : AppCompatActivity() {

    private lateinit var adapter:FilmAdapter
    private lateinit var filmViewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        filmViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[FilmViewModel::class.java]
        adapter = FilmAdapter()
        adapter.notifyDataSetChanged()
        rv_films.layoutManager = LinearLayoutManager(this)
        rv_films.adapter = adapter

        filmViewModel.getFilmData(1)
        showLoading(true)
        subscribe()
    }

    private fun subscribe() {
        filmViewModel.setFilmData().observe(this, {
            if(it!= null){
                val dummy = filmViewModel.getDummyFilm()
                adapter.setFilm(it,dummy)
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
