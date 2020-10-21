package com.onoh.mystarwarsapp.ui.home.ratingmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.FilmEntity
import com.onoh.mystarwarsapp.data.remote.result.FilmResult
import kotlinx.android.synthetic.main.item_poster_movie.view.*

class HighRatingMovieAdapter : RecyclerView.Adapter<HighRatingMovieAdapter.RatingViewHolder>(){
    private var listFilm = ArrayList<FilmResult>()
    private var listDummy = ArrayList<FilmEntity>()

    fun setFilm(film: ArrayList<FilmResult>,dummy:List<FilmEntity>){
        listFilm.clear()
        listDummy.clear()
        listFilm.addAll(film)
        listDummy.addAll(dummy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poster_movie,parent,false)
        return RatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        val new = listFilm[position]
        val dummy = listDummy[position]
        holder.bind(new,dummy)
    }

    override fun getItemCount(): Int = listFilm.size

    class RatingViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(film: FilmResult,dummy:FilmEntity) {
            with(itemView) {
                tv_title_high_rating.text = film.title
                tv_desc_high_rating.text = film.openingCrawl
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_poster_rating)
//                setOnClickListener {
//                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
//                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
//                    }
//                    context.startActivity(intent)
//                }
//
            }
        }
    }
}