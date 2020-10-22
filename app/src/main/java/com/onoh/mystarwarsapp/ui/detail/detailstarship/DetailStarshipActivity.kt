package com.onoh.mystarwarsapp.ui.detail.detailstarship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.StarshipEntity
import com.onoh.mystarwarsapp.data.remote.result.DetailStarshipResult
import com.onoh.mystarwarsapp.ui.detail.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail_profile.btn_close_detail
import kotlinx.android.synthetic.main.activity_detail_profile.progressBar
import kotlinx.android.synthetic.main.activity_detail_starship.*

class DetailStarshipActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STARSHIP = "extra_starship"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_starship)
        btn_close_detail.setOnClickListener{finish()}

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras!=null){
            val id = extras.getInt(EXTRA_STARSHIP)
            viewModel.getStarshipData(id)
            viewModel.setSelectedStarshipDummy(id.toString())
            setupDetail(viewModel.setDetailStarship(),viewModel.getDummyStarshipData())
            progressBar.visibility = View.VISIBLE
        }

    }

    private fun setupDetail(detailStarship: LiveData<DetailStarshipResult>, dummyStarshipData: StarshipEntity) {
        detailStarship.observe(this, Observer {
            if(it == null){
                Toast.makeText(this,resources.getString(R.string.data_not_found),Toast.LENGTH_LONG).show()
                finish()
            }else{
                tv_detail_starship_name.text = it.name
                tv_detail_starship_model.text = it.model
                tv_detail_starship_manufacturer.text = it.manufacture
                tv_detail_starship_length.text = it.length
                tv_detail_starship_passenger.text = it.passenger
                tv_detail_starship_cargo.text = it.cargoCapacity
                progressBar.visibility = View.GONE
            }
        })
        Glide.with(this)
            .load(dummyStarshipData.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_detail_starship)
    }
}
