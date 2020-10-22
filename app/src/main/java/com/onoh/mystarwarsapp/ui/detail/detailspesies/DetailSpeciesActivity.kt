package com.onoh.mystarwarsapp.ui.detail.detailspesies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.SpeciesEntity
import com.onoh.mystarwarsapp.data.remote.result.DetailSpeciesResult
import com.onoh.mystarwarsapp.ui.detail.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail_profile.btn_close_detail
import kotlinx.android.synthetic.main.activity_detail_profile.progressBar
import kotlinx.android.synthetic.main.activity_detail_species.*

class DetailSpeciesActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_SPECIES = "extra_species"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_species)
        btn_close_detail.setOnClickListener{finish()}

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras!=null){
            val id = extras.getInt(EXTRA_SPECIES)
            viewModel.getSpeciesData(id)
            viewModel.setSelectedSpeciesDummy(id.toString())
            setupDetail(viewModel.setDetailSpecies(),viewModel.getDummySpeciesData())
            progressBar.visibility = View.VISIBLE
        }

    }

    private fun setupDetail(detailSpecies: LiveData<DetailSpeciesResult>, dummySpeciesData: SpeciesEntity) {
        detailSpecies.observe(this, {
            tv_detail_species_name.text = it.name
            tv_detail_species_designation.text = it.designation
            tv_detail_species_class.text = it.classification
            tv_detail_species_language.text = it.language
            progressBar.visibility = View.GONE
        })
        Glide.with(this)
            .load(dummySpeciesData.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_detail_species)
    }
}
