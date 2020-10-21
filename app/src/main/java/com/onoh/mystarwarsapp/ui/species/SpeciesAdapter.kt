package com.onoh.mystarwarsapp.ui.species

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.SpeciesEntity
import com.onoh.mystarwarsapp.data.remote.result.SpeciesResult
import com.onoh.mystarwarsapp.data.remote.result.StarshipResult
import kotlinx.android.synthetic.main.item_species.view.*
import kotlinx.android.synthetic.main.item_starship.view.*

class SpeciesAdapter : RecyclerView.Adapter<SpeciesAdapter.ViewHolder>(){
    private var listSpecies = ArrayList<SpeciesResult>()
    private var listDummy = ArrayList<SpeciesEntity>()

    fun setSpecies(species: ArrayList<SpeciesResult>,dummy:List<SpeciesEntity>){
        listSpecies.clear()
        listDummy.clear()
        listSpecies.addAll(species)
        listDummy.addAll(dummy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_species,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = listSpecies[position]
        val dummy = listDummy[position]
        holder.bind(new,dummy)
    }

    override fun getItemCount(): Int = listSpecies.size

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(species: SpeciesResult,dummy:SpeciesEntity) {
            with(itemView) {
                tv_name_species.text = species.name
                tv_classification_species.text = species.classification
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_species)
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