package com.omkarcodes.movee.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.ui.saved.MoveeDao

@Database(entities = [Movie::class],version = 1, exportSchema = false)
abstract class MoveeDatabase : RoomDatabase() {
    abstract fun getDao(): MoveeDao
}