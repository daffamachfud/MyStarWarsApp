package com.onoh.mystarwarsapp.ui.starship

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.StarshipEntity
import com.onoh.mystarwarsapp.data.remote.response.StartshipResponse
import com.onoh.mystarwarsapp.data.remote.result.PeopleResult
import com.onoh.mystarwarsapp.data.remote.result.StarshipResult
import com.onoh.mystarwarsapp.ui.people.PeopleAdapter
import kotlinx.android.synthetic.main.item_film.view.*
import kotlinx.android.synthetic.main.item_people.view.*
import kotlinx.android.synthetic.main.item_starship.view.*

class StarshipAdapter : RecyclerView.Adapter<StarshipAdapter.StarViewHolder>(){
    private var listStarship = ArrayList<StarshipResult>()
    private var listDummy = ArrayList<StarshipEntity>()

    fun setStarship(starship: ArrayList<StarshipResult>,dummy:List<StarshipEntity>){
        listStarship.clear()
        listDummy.clear()
        listStarship.addAll(starship)
        listDummy.addAll(dummy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_starship,parent,false)
        return StarViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarViewHolder, position: Int) {
        val new = listStarship[position]
        val dummy = listDummy[position]
        holder.bind(new,dummy)
    }

    override fun getItemCount(): Int = listStarship.size

    class StarViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(starship: StarshipResult,dummy:StarshipEntity) {
            with(itemView) {
                tv_name_starship.text = starship.name
                tv_model_starship.text = starship.model
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_starship)
//                setOnClickListener {
//                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
//                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
//                    }
//                    context.startActivity(intent)
//                }

            }
        }
    }
}