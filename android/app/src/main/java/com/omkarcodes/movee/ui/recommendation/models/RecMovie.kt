package com.omkarcodes.movee.ui.recommendation.models

data class RecMovie(
    val avg_rating: Double,
    val genres: String,
    val movieId: Int,
    val overview: String,
    val poster_path: String,
    val title: String,
    val vote_count: Int,
)