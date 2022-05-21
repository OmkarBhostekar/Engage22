package com.omkarcodes.movee.ui.search

import com.omkarcodes.movee.models.PagingWrapper
import com.omkarcodes.movee.ui.search.models.SearchResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/3/search/multi/")
    suspend fun search(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("language") language: String = "en-US"
    ) : PagingWrapper<List<SearchResult>>
}