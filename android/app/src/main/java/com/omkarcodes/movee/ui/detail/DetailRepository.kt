package com.omkarcodes.movee.ui.detail

import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.ui.saved.MoveeDao
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val api: DetailApi,
    private val dao: MoveeDao
){
    suspend fun getMovieDetail(movieId:Int) = api.getMovieDetail(movieId)

    suspend fun getTvDetail(tvId:Int) = api.getTvShowDetail(tvId)

    suspend fun getCredits(type:String, id:Int) = api.getCredits(type, id)

    fun insertMovie(movie: Movie) = dao.insertMovie(movie)

}