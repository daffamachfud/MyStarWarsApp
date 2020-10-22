package com.onoh.mystarwarsapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.ui.film.FilmActivity
import com.onoh.mystarwarsapp.ui.home.news.NewsAdapter
import com.onoh.mystarwarsapp.ui.home.news.NewsWebActivity
import com.onoh.mystarwarsapp.ui.home.ratingmovie.HighRatingMovieAdapter
import kotlinx.android.synthetic.main.layout_high_rating_movie.*
import kotlinx.android.synthetic.main.layout_news.*

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity!=null){

            tv_view_more_movie.setOnClickListener(this)
            tv_view_more_news.setOnClickListener(this)

            homeViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]

            val news = homeViewModel.getNews()
            val film = homeViewModel.getHighRating()

            val newsAdapter = NewsAdapter()
            val filmAdapter = HighRatingMovieAdapter()

            newsAdapter.setNews(news)
            filmAdapter.setFilm(film)
            with(rv_news){
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
                setHasFixedSize(true)
                adapter = newsAdapter
            }
            with(rv_high_rating){
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
                setHasFixedSize(true)
                adapter = filmAdapter
            }
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.tv_view_more_movie){
            val intent = Intent(requireActivity(),FilmActivity::class.java)
            startActivity(intent)
        }else if(v?.id ==R.id.tv_view_more_news){
            val intentNews = Intent(requireActivity(),NewsWebActivity::class.java)
            startActivity(intentNews)
        }
    }


}
