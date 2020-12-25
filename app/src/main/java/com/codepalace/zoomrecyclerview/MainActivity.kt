package com.codepalace.zoomrecyclerview

import android.graphics.drawable.Drawable
import android.icu.text.CaseMap
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout

class MainActivity : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    private var ratingList = mutableListOf<Int>()
    private var drawableList = mutableListOf<Int>()

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        recyclerView = findViewById(R.id.rv_recycler)

        addToList("Nice place", R.drawable.photo_one, 3)
        addToList("Nice place Two", R.drawable.photo_two, 4)
        addToList("Nice place Three", R.drawable.photo_three, 2)
        setUpRecyclerView()
    }

    private fun addToList( title: String, image: Int, rating: Int) {
        titleList.add(title)
        drawableList.add(image)
        ratingList.add(rating)
    }

    private fun setUpRecyclerView() {
        val linearLayoutManager = ZoomRecyclerLayout(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView) // Add your recycler view here
        recyclerView.isNestedScrollingEnabled = false

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = RecyclerAdapter(drawableList, titleList, ratingList)
    }
}