package com.dicoding.submissionproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    val title: String,
    val descriptionList: String,
    val photo: String,
    val description: String,
    val premiere: String
) : Parcelable
