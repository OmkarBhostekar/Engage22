package com.omkarcodes.movee.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(
        @PrimaryKey
    val id: Int,
    val title: String,
    val posterUrl:String,
    val backdropUrl: String,
    val genres: String,
    val language: String,
    val addedOn: Long,
    val type: String = "movie",
)
