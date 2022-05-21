package com.omkarcodes.movee.ui.saved

import com.omkarcodes.movee.models.Movie
import javax.inject.Inject

class savedRepository @Inject constructor(
        val dao: MoveeDao,
) {
    fun getSaved() = dao.getFav()

    fun deleteMovie(movie: Movie) = dao.deleteMovie(movie)
}