package com.onoh.mystarwarsapp.ui.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.data.local.NewsEntity
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    private var listNews = ArrayList<NewsEntity>()

    fun setNews(news: List<NewsEntity>){
        listNews.clear()
        listNews.addAll(news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val new = listNews[position]
        holder.bind(new)
    }

    override fun getItemCount(): Int = listNews.size

    class NewsViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun bind(new: NewsEntity) {
            with(itemView) {
                tv_title_news.text = new.title
                tv_desc_news.text = new.description
//                setOnClickListener {
//                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
//                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
//                    }
//                    context.startActivity(intent)
//                }
                Glide.with(context)
                    .load(new.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_news)
            }
        }
    }
}