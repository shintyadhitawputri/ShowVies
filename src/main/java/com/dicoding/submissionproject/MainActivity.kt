package com.dicoding.myrecyclerview

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissionproject.AboutMe
import com.dicoding.submissionproject.Movies

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movies>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId) {
                R.id.btn_about -> {
                    val aboutMe = Intent(this, AboutMe::class.java)
                    startActivity(aboutMe)
                }
            }
        return super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration){
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvMovies.layoutManager = LinearLayoutManager(this)
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvMovies.layoutManager = GridLayoutManager(this, 2)
        }
    }

    private fun getListMovies(): ArrayList<Movies> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescList = resources.getStringArray(R.array.data_descriptionlist)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataPremiere = resources.getStringArray(R.array.data_premiere)
        val dataDescription = resources.getStringArray(R.array.data_description)

        val listMovies = ArrayList<Movies>()
        for (i in dataTitle.indices) {
            val movie = Movies(dataTitle[i], dataDescList[i], dataPhoto[i], dataDescription[i], dataPremiere[i])
            listMovies.add(movie)
        }
        return listMovies
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMoviesAdapter = ListMoviesAdapter(list)
        rvMovies.adapter = listMoviesAdapter
    }

}
