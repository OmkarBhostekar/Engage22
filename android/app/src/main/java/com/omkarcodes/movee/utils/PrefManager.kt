package com.omkarcodes.movee.utils

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {

    private val mSharedPreferences: SharedPreferences
    private val mEditor: SharedPreferences.Editor

    companion object {
        // SharedPreference Keys
        private const val PREFS_NAME = "Settings"
        private const val PREFS_MODE = Context.MODE_PRIVATE
        private const val MOVIE_ID = "movieId"
        private const val TMDB_ID = "tmdbId"
        private const val GEN1 = "gen1"
        private const val GEN2 = "gen2"
        private const val GEN3 = "gen3"
        private const val ONBOARD_DONE = "isOnBoardDone"
    }

    init {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, PREFS_MODE)
        mEditor = mSharedPreferences.edit()
    }

    fun clearUserPrefs() {
        mEditor.clear()
        mEditor.apply()
    }

    fun updateIds(movieId: Int, tmdbId: Int) {
        mEditor.putInt(MOVIE_ID, movieId)
        mEditor.putInt(TMDB_ID, tmdbId)
        mEditor.apply()
    }

    fun updateGen1(genre: String){
        mEditor.putString(GEN1, genre)
        mEditor.apply()
    }

    fun updateGen2(genre: String){
        mEditor.putString(GEN2, genre)
        mEditor.apply()
    }

    fun updateGen3(genre: String){
        mEditor.putString(GEN3, genre)
        mEditor.apply()
    }

    fun setOnBoardDone(){
        mEditor.putBoolean(ONBOARD_DONE, true)
        mEditor.apply()
    }

    fun getRecentMovieId(): Int {
        return mSharedPreferences.getInt(MOVIE_ID,1)
    }

    fun getRecentTmdbId(): Int {
        return mSharedPreferences.getInt(TMDB_ID,24428)
    }

    fun getGen1(): String {
        return mSharedPreferences.getString(GEN1,"Animation") ?: "Animation"
    }

    fun getGen2(): String {
        return mSharedPreferences.getString(GEN2,"Fantasy") ?: "Fantasy"
    }

    fun getGen3(): String {
        return mSharedPreferences.getString(GEN3,"Thriller") ?: "Thriller"
    }

    fun getOnBoardDone(): Boolean {
        return mSharedPreferences.getBoolean(ONBOARD_DONE,false)
    }

}