package com.dicoding.submissionproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.myrecyclerview.MainActivity
import com.dicoding.myrecyclerview.R

class SplashScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        @Suppress("DEPRECATION")
        Handler().postDelayed({
            val intentSplash = Intent(this, MainActivity::class.java)
            startActivity(intentSplash)
            finish()
        }, 2500)
    }
}