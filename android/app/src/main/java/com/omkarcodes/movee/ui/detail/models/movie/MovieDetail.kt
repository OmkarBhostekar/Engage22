package com.omkarcodes.movee.ui.detail.models.movie

import com.omkarcodes.movee.ui.detail.models.tv.Genre
import com.omkarcodes.movee.ui.detail.models.tv.ProductionCompany
import com.omkarcodes.movee.ui.detail.models.tv.ProductionCountry
import com.omkarcodes.movee.ui.detail.models.tv.SpokenLanguage

data class MovieDetail(
        val adult: Boolean,
        val backdrop_path: String,
        val belongs_to_collection: BelongsToCollection,
        val budget: Int,
        val genres: List<Genre>,
        val homepage: String,
        val id: Int,
        val imdb_id: String,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val production_companies: List<ProductionCompany>,
        val production_countries: List<ProductionCountry>,
        val release_date: String,
        val revenue: Long,
        val runtime: Int,
        val spoken_languages: List<SpokenLanguage>,
        val status: String,
        val tagline: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
)