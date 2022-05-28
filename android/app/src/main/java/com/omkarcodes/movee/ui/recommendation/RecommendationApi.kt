package com.omkarcodes.movee.ui.recommendation

import com.omkarcodes.movee.ui.recommendation.models.RecMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendationApi {

    @GET("movie/top-rated")
    suspend fun getTopRated() : Response<List<RecMovie>>

    @GET("movie/content-recommendation")
    suspend fun getContentBased(
        @Query("tmdbId") movieId: Int
    ) : Response<List<RecMovie>>

    @GET("movie/cf-recommendation")
    suspend fun getCfRecom(
        @Query("movieId") movieId: Int
    ) : Response<List<RecMovie>>

    @GET("movie/")
    suspend fun getByGenres(
        @Query("genre") genre: String
    ) : Response<List<RecMovie>>
}