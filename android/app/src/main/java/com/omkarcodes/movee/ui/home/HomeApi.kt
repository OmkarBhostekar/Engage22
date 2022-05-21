package com.omkarcodes.movee.ui.home

import com.omkarcodes.movee.models.PagingWrapper
import com.omkarcodes.movee.ui.home.models.NetflixOg
import com.omkarcodes.movee.ui.home.models.PopularMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("/3/discover/tv")
    suspend fun getNetflixOriginals(
            @Query("api_key") apiKey: String,
            @Query("with_network") network: Int = 213,
    ): Response<PagingWrapper<List<NetflixOg>>>

    @GET("/3/tv/popular")
    suspend fun getPopularTvShows(
            @Query("api_key") apiKey: String,
            @Query("language") language: String = "en-US"
    ): Response<PagingWrapper<List<NetflixOg>>>

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int = 1,
            @Query("language") language: String = "en-US"
    ): Response<PagingWrapper<List<PopularMovie>>>

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int = 1,
            @Query("language") language: String = "en-US"
    ): Response<PagingWrapper<List<PopularMovie>>>

    @GET("/3/discover/movie")
    suspend fun getMcuMovies(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int = 1,
            @Query("language") language: String = "en-US",
            @Query("with_companies") companies: String = "420|19551|38679|2301|13252",
    ): Response<PagingWrapper<List<PopularMovie>>>
}