package com.onoh.mystarwarsapp.ui.home.ratingmovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.FilmEntity
import com.onoh.mystarwarsapp.ui.detail.detailfilm.DetailFilmActivity
import kotlinx.android.synthetic.main.item_poster_movie.view.*

class HighRatingMovieAdapter : RecyclerView.Adapter<HighRatingMovieAdapter.RatingViewHolder>(){
    private var listDummy = ArrayList<FilmEntity>()

    fun setFilm(dummy:List<FilmEntity>){
        listDummy.clear()
        listDummy.addAll(dummy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poster_movie,parent,false)
        return RatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        val dummy = listDummy[position]
        holder.bind(dummy,position+1)
    }

    override fun getItemCount(): Int = listDummy.size

    class RatingViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(dummy:FilmEntity,position: Int) {
            with(itemView) {
                tv_title_high_rating.text = dummy.title
                tv_desc_high_rating.text = dummy.description
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_poster_rating)
                setOnClickListener {
                    val intent = Intent(context, DetailFilmActivity::class.java).apply {
                        putExtra(DetailFilmActivity.EXTRA_FILM, position)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}