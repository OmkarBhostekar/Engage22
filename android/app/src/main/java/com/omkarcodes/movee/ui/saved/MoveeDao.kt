package com.omkarcodes.movee.ui.saved

import androidx.lifecycle.LiveData
import androidx.room.*
import com.omkarcodes.movee.models.Movie

@Dao
interface MoveeDao {

    @Insert(entity = Movie::class,onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Delete(entity = Movie::class)
    fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM movie ORDER BY addedOn DESC")
    fun getFav() : LiveData<List<Movie>>
}