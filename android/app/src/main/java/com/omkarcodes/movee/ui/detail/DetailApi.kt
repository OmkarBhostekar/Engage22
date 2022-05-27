package com.omkarcodes.movee.ui.detail

import com.omkarcodes.movee.comman.Constants
import com.omkarcodes.movee.ui.detail.models.RecResponse
import com.omkarcodes.movee.ui.detail.models.movie.MovieDetail
import com.omkarcodes.movee.ui.detail.models.tv.CastResponse
import com.omkarcodes.movee.ui.detail.models.tv.TvDetail
import com.omkarcodes.movee.ui.detail.models.video.MovieVideos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailApi {

    @GET("/3/movie/{movieId}")
    suspend fun getMovieDetail(
            @Path("movieId") movieId: Int,
            @Query("api_key") apiKey: String = Constants.API_KEY,
            @Query("language") language: String = "en-US"
    ) : Response<MovieDetail>

    @GET("/3/tv/{tvId}")
    suspend fun getTvShowDetail(
            @Path("tvId") tvId: Int,
            @Query("api_key") apiKey: String = Constants.API_KEY,
            @Query("language") language: String = "en-US"
    ) : Response<TvDetail>

    @GET("/3/{type}/{id}/credits")
    suspend fun getCredits(
            @Path("type") type: String,
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = Constants.API_KEY,
            @Query("language") language: String = "en-US"
    ): Response<CastResponse>

    @GET("/3/{type}/{id}/videos")
    suspend fun getVideos(
        @Path("type") type: String = "movie",
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): Response<MovieVideos>

    @GET("/3/{type}/{id}/recommendations")
    suspend fun getRecom(
        @Path("type") type: String,
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en-US"
    ): Response<RecResponse>

}