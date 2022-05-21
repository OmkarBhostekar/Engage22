package com.omkarcodes.movee.ui.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkarcodes.movee.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
        private val repository: savedRepository
) : ViewModel() {

    fun getSaved() = repository.getSaved()

    fun  deleteMovie(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteMovie(movie)
    }
}