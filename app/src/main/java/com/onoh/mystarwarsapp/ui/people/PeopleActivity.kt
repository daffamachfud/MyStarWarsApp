package com.onoh.mystarwarsapp.ui.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.mystarwarsapp.R
import kotlinx.android.synthetic.main.activity_people.*

class PeopleActivity : AppCompatActivity() {

    private lateinit var adapter: PeopleAdapter
    private lateinit var peopleViewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        peopleViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[PeopleViewModel::class.java]
        adapter = PeopleAdapter()
        adapter.notifyDataSetChanged()
        rv_people.layoutManager = LinearLayoutManager(this)
        rv_people.adapter = adapter

        peopleViewModel.getPeopleData(1)
        showLoading(true)
        subscribe()
    }

    private fun subscribe() {
        peopleViewModel.setPeopleData().observe(this, {
            if(it!= null){
                val dummy = peopleViewModel.getDummyFilm()
                adapter.setPeople(it,dummy)
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
