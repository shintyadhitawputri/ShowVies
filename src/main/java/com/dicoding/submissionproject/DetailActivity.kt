package com.dicoding.submissionproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.myrecyclerview.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailTitle = findViewById<TextView>(R.id.tv_item_title)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_item_description)
        val tvDetailPhoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvDetailPremiere = findViewById<TextView>(R.id.tv_item_premiere)
        val btnShare = findViewById<Button>(R.id.btn_share)

        @Suppress("DEPRECATION")
        val dataMovies = intent.getParcelableExtra<Movies>("key_movies")

        if (dataMovies != null) {
            tvDetailTitle.text = dataMovies.title
            tvDetailDescription.text = dataMovies.description
            Glide.with(this)
                .load(dataMovies.photo)
                .into(tvDetailPhoto)
            tvDetailPremiere.text = dataMovies.premiere
        }

        btnShare.setOnClickListener {
            shareInfo(dataMovies)
        }
    }

    private fun shareInfo(movie: Movies?) {
        if (movie != null) {
            val shareMovies = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hai! I want to share you my movie recommendation! " +
                        "\nTitle: ${movie.title}" +
                        "\nPremier Date: ${movie.premiere}" +
                        "\nAbout the Movie: ${movie.description}")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareMovies, "Share Movie!"))
        }
    }
}