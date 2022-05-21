package com.omkarcodes.movee.comman

import com.omkarcodes.movee.ui.detail.models.tv.Genre
import com.omkarcodes.movee.ui.home.models.NetflixOg
import com.omkarcodes.movee.ui.home.models.PopularMovie

fun NetflixOg.toMovie(): PopularMovie{
    this.apply {
        return PopularMovie(adult = false,backdrop_path,genre_ids,id,original_language,original_name,overview,popularity,poster_path,first_air_date,name,false,vote_average,vote_count)
    }
}

fun List<Int>.toGenreList(): String {
    val list = mutableListOf<String>()
    this.forEach { genreId ->
        val genre = genreId.getGenre()
        if (genre.isNotEmpty()){
            list.add(genre)
        }
    }
    return if(list.isEmpty()) "" else if (list.size > 1) list.joinToString(", ") else list.first()
}

fun Int.getGenre(): String {
    return when(this){
        28 -> "Action"
        12 -> "Adventure"
        16 -> "Animation"
        35 -> "Comedy"
        80 -> "Crime"
        99 -> "Documentary"
        18 -> "Drama"
        10751 -> "Family"
        14 -> "Fantasy"
        36 -> "History"
        27 -> "Horror"
        10402 -> "Music"
        9648 -> "Mystery"
        10749 -> "Romance"
        878 -> "Science Fiction"
        10770 -> "TV Movie"
        53 -> "Thriller"
        10752 -> "War"
        37 -> "Western"
        else -> ""
    }
}

fun List<Genre>.toGenres(): String {
    val list = this.map {
        it.name
    }
    return list.joinToString(", ")
}