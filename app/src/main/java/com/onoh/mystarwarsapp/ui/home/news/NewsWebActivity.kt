package com.onoh.mystarwarsapp.ui.home.news

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onoh.mystarwarsapp.R
import kotlinx.android.synthetic.main.activity_news_web.*

class NewsWebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_web)

        newWebView.settings.javaScriptEnabled = true
        newWebView.loadUrl("https://www.starwars.com/news")
    }
}
