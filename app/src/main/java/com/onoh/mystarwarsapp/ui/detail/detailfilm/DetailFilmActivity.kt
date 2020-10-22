package com.onoh.mystarwarsapp.ui.detail.detailfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.FilmEntity
import com.onoh.mystarwarsapp.data.remote.result.DetailFilmResult
import com.onoh.mystarwarsapp.ui.detail.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail_film.*
import kotlinx.android.synthetic.main.activity_detail_profile.btn_close_detail
import kotlinx.android.synthetic.main.activity_detail_profile.progressBar

class DetailFilmActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_FILM = "extra_film"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)
        btn_close_detail.setOnClickListener{finish()}

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras!=null){
            val id = extras.getInt(EXTRA_FILM)
            viewModel.getFilmData(id)
            viewModel.setSelectedFilmDummy(id.toString())
            setupDetail(viewModel.setDetailFilm(),viewModel.getDummyFilmData())
            progressBar.visibility = View.VISIBLE
        }

    }

    private fun setupDetail(detailFilm: LiveData<DetailFilmResult>, dummyFilmData: FilmEntity) {
        detailFilm.observe(this, Observer {
            tv_detail_film_title.text=it.title
            tv_detail_film_release_date.text=it.releaseDate
            tv_detail_film_director.text=it.director
            tv_detail_film_producer.text=it.producer
            tv_detail_film_crawl.text=it.openingCrawl
            progressBar.visibility = View.GONE
        })
        Glide.with(this)
            .load(dummyFilmData.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_detail_film)
    }




}
