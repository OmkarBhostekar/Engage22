package com.omkarcodes.movee.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
        private val repository: SearchRepository
) : ViewModel() {

    fun search(q: String) = repository.search(q).cachedIn(viewModelScope)
}