package com.onoh.mystarwarsapp.ui.detail.detailpeople

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.PeopleEntity
import com.onoh.mystarwarsapp.data.remote.result.DetailPeopleResult
import com.onoh.mystarwarsapp.ui.detail.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail_profile.*

class DetailProfileActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PEOPLE = "extra_people"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile)
        btn_close_detail.setOnClickListener{finish()}

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras!=null){
            val id = extras.getInt(EXTRA_PEOPLE)
            viewModel.getPeopleData(id)
            viewModel.setSelectedPeople(id.toString())
            setupDetail(viewModel.setPeopleData(),viewModel.getDummyPeopleData())
            progressBar.visibility = View.VISIBLE
        }

    }

    private fun setupDetail(peopleData: LiveData<DetailPeopleResult>, dummyPeopleData: PeopleEntity) {
        peopleData.observe(this, {
            tv_detail_people_name.text=it.name
            tv_detail_people_bth.text=it.birthDay
            tv_detail_people_gender.text=it.gender
            tv_detail_people_height.text=it.height.toString()
            tv_detail_people_mass.text=it.mass.toString()
            progressBar.visibility = View.GONE
        })
        Glide.with(this)
            .load(dummyPeopleData.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_detail_people)
    }



}
