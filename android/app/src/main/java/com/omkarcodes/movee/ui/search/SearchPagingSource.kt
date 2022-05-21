package com.omkarcodes.movee.ui.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.omkarcodes.movee.comman.Constants.API_KEY
import com.omkarcodes.movee.comman.Constants.STARTING_INDEX
import com.omkarcodes.movee.ui.search.models.SearchResult
import java.util.concurrent.TimeoutException

class SearchPagingSource(
    private val api: SearchApi,
    private val query: String
) : PagingSource<Int,SearchResult>() {
    override fun getRefreshKey(state: PagingState<Int, SearchResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResult> {
        val page = params.key ?: STARTING_INDEX
        return try{
            val response = api.search(API_KEY,query,page)
            LoadResult.Page(
                data = response.results,
                nextKey = if(page != response.total_pages) page+1 else null ,
                prevKey = if (page == STARTING_INDEX) null else page-1
            )
        }catch(e: TimeoutException){
            LoadResult.Error(e)
        }catch(e: Exception){
            LoadResult.Error(e)
        }
    }
}