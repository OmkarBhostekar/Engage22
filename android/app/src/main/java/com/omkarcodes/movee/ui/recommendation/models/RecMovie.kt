package com.omkarcodes.movee.ui.recommendation.models

data class RecMovie(
    val movieId: Int,
    val poster_path: String,
    val backdrop_path: String,
    val title: String,
    val tmdbId: Int = 0,
)