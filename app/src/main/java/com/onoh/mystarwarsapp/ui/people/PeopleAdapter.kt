package com.onoh.mystarwarsapp.ui.people

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.PeopleEntity
import com.onoh.mystarwarsapp.data.remote.result.PeopleResult
import com.onoh.mystarwarsapp.ui.detail.detailpeople.DetailProfileActivity
import kotlinx.android.synthetic.main.item_people.view.*

class PeopleAdapter  : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){
    private var listPeople = ArrayList<PeopleResult>()
    private var listDummy = ArrayList<PeopleEntity>()

    fun setPeople(peoples: ArrayList<PeopleResult>,dummy:List<PeopleEntity>){
        listPeople.clear()
        listDummy.clear()
        listPeople.addAll(peoples)
        listDummy.addAll(dummy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people,parent,false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val new = listPeople[position]
        val dummy = listDummy[position]
        holder.bind(new,dummy,position+1)
    }

    override fun getItemCount(): Int = listPeople.size

    class PeopleViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        fun bind(people: PeopleResult,dummy:PeopleEntity,position: Int) {
            with(itemView) {
                tv_name_people.text = people.name
                Glide.with(context)
                    .load(dummy.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_people)
                setOnClickListener{
                    val intent = Intent(context, DetailProfileActivity::class.java).apply {
                        putExtra(DetailProfileActivity.EXTRA_PEOPLE, position)
                    }
                    context.startActivity(intent)
                }
            }

        }


    }
}