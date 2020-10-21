package com.onoh.mystarwarsapp.ui.vehicles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.VehiclesEntity
import com.onoh.mystarwarsapp.data.remote.result.StarshipResult
import com.onoh.mystarwarsapp.data.remote.result.VehicleResult
import kotlinx.android.synthetic.main.item_starship.view.*
import kotlinx.android.synthetic.main.item_vehicles.view.*

class VehiclesAdapter : RecyclerView.Adapter<VehiclesAdapter.ViewHolder>(){
    private var listVehicles = ArrayList<VehicleResult>()
    private var listDummy = ArrayList<VehiclesEntity>()

    fun setVehicles(vehicle: ArrayList<VehicleResult>,dummy:List<VehiclesEntity>){
        listVehicles.clear()
        listDummy.clear()
        listVehicles.addAll(vehicle)
        listDummy.addAll(dummy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vehicles,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = listVehicles[position]
        val dummy = listDummy[position]
        holder.bind(new,dummy)
    }

    override fun getItemCount(): Int = listVehicles.size

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(vehicle: VehicleResult,dummy:VehiclesEntity) {
            with(itemView) {
                tv_name_vehicles.text = vehicle.name
                tv_model_vehicles.text = vehicle.model
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_vehicles)
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