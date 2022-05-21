package com.omkarcodes.movee.ui.search

import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject

class SearchRepository @Inject constructor(
        private val api: SearchApi
) {
    fun search(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            SearchPagingSource(api,query = query)
        }
    ).flow
}