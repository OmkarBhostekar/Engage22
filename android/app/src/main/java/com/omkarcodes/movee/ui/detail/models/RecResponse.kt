package com.omkarcodes.movee.ui.detail.models

data class RecResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)