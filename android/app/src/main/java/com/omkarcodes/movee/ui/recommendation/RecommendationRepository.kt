package com.omkarcodes.movee.ui.recommendation

import javax.inject.Inject

class RecommendationRepository @Inject constructor(
    private val api: RecommendationApi
) {

    suspend fun getTopRated() = api.getTopRated()

    suspend fun getContentBased(movieId: Int) = api.getContentBased(movieId)

    suspend fun getCfRecom(movieId: Int) = api.getCfRecom(movieId)

    suspend fun getByGenres(genre: String) = api.getByGenres(genre)
}