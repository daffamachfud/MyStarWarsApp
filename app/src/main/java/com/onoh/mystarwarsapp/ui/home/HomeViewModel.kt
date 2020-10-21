package com.onoh.mystarwarsapp.ui.home

import androidx.lifecycle.ViewModel
import com.onoh.mystarwarsapp.data.local.NewsEntity
import com.onoh.mystarwarsapp.utils.DataDummy

class HomeViewModel() : ViewModel() {

    fun getNews():List<NewsEntity> = DataDummy.generateNews()
}