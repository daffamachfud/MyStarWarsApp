package com.onoh.mystarwarsapp.ui.film

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.FilmEntity
import com.onoh.mystarwarsapp.data.remote.result.FilmResult
import com.onoh.mystarwarsapp.ui.detail.detailfilm.DetailFilmActivity
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter  : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>(){
    private var listFilm = ArrayList<FilmResult>()
    private var listDummy = ArrayList<FilmEntity>()

    fun setFilm(films: ArrayList<FilmResult>,dummy:List<FilmEntity>){
        listFilm.clear()
        listDummy.clear()
        listFilm.addAll(films)
        listDummy.addAll(dummy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        val dummy = listDummy[position]
        holder.bind(film,dummy,position+1)
    }

    override fun getItemCount(): Int = listFilm.size

    class FilmViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(film: FilmResult,dummy:FilmEntity,position: Int) {
            with(itemView) {
                tv_title_film.text = film.title
                tv_desc_film.text = film.openingCrawl
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_poster)
              setOnClickListener{
                    val intent = Intent(context, DetailFilmActivity::class.java).apply {
                        putExtra(DetailFilmActivity.EXTRA_FILM, position)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}