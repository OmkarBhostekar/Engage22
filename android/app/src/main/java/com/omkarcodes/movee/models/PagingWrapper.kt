package com.omkarcodes.movee.models

data class PagingWrapper<T>(
        val page: Int,
        val results: T,
        val total_pages: Int
)