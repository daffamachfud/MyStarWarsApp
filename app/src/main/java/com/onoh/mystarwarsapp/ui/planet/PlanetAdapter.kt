package com.onoh.mystarwarsapp.ui.planet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.PlanetEntity
import com.onoh.mystarwarsapp.data.remote.result.PlanetResult
import com.onoh.mystarwarsapp.data.remote.result.SpeciesResult
import kotlinx.android.synthetic.main.item_planet.view.*
import kotlinx.android.synthetic.main.item_species.view.*
import kotlinx.android.synthetic.main.item_starship.view.*

class PlanetAdapter : RecyclerView.Adapter<PlanetAdapter.ViewHolder>(){
    private var listPlanet = ArrayList<PlanetResult>()
    private var listDummy = ArrayList<PlanetEntity>()

    fun setPlanet(planet: ArrayList<PlanetResult>,dummy:List<PlanetEntity>){
        listPlanet.clear()
        listDummy.clear()
        listPlanet.addAll(planet)
        listDummy.addAll(dummy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = listPlanet[position]
        val dummy = listDummy[position]
        holder.bind(new,dummy)
    }

    override fun getItemCount(): Int = listPlanet.size

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(planet: PlanetResult,dummy:PlanetEntity) {
            with(itemView) {
                tv_name_planet.text = planet.name
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_planet)
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