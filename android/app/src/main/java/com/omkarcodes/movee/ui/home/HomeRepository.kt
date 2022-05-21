package com.omkarcodes.movee.ui.home

import com.omkarcodes.movee.comman.Constants
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: HomeApi
) {
    val apiKey = Constants.API_KEY

    suspend fun getNetflixOg() = api.getNetflixOriginals(apiKey)
    suspend fun getPopularMovies() = api.getPopularMovies(apiKey)
    suspend fun getNowPlayingMovies() = api.getNowPlayingMovies(apiKey)
    suspend fun getMcuMovies() = api.getMcuMovies(apiKey)
    suspend fun getPopularTvShows() = api.getPopularTvShows(apiKey)

}