package com.omkarcodes.movee.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.detail.models.movie.MovieDetail
import com.omkarcodes.movee.ui.detail.models.tv.Cast
import com.omkarcodes.movee.ui.detail.models.tv.TvDetail
import com.omkarcodes.movee.ui.detail.models.video.Result
import com.omkarcodes.movee.ui.recommendation.models.RecMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository,
) : ViewModel(){

    val movieDetail = MutableLiveData<Resource<MovieDetail>>(Resource.Empty())
    val tvDetail = MutableLiveData<Resource<TvDetail>>(Resource.Empty())
    val cast = MutableLiveData<Resource<List<Cast>>>(Resource.Empty())
    val videos = MutableLiveData<Resource<List<Result>>>(Resource.Empty())
    val recom = MutableLiveData<Resource<List<RecMovie>>>(Resource.Empty())
    val tmdbRecom = MutableLiveData<Resource<List<com.omkarcodes.movee.ui.detail.models.Result>>>(Resource.Empty())

    fun getMovieDetail(movieId: Int) = viewModelScope.launch {
        try{
            val response = repository.getMovieDetail(movieId)
            Timber.tag("movie-detail").d(response.body().toString())
            if (response.isSuccessful)
                movieDetail.postValue(Resource.Success(response.body()!!))
        }catch(e: Exception){
        }
    }

    fun getTvDetail(tvId: Int) = viewModelScope.launch {
        try{
            val response = repository.getTvDetail(tvId)
            if (response.isSuccessful)
                tvDetail.postValue(Resource.Success(response.body()!!))
        }catch(e: Exception){
        }
    }

    fun getCast(type: String, id: Int) = viewModelScope.launch {
        try {
            val response = repository.getCredits(type,id)
            if (response.isSuccessful)
                cast.postValue(Resource.Success(response.body()!!.cast))
        }catch(e: Exception){
        }
    }

    fun getVideos(type: String,id: Int) = viewModelScope.launch {
        try {
            val response = repository.getVideos(type,id)
            if (response.isSuccessful){
                val list = mutableListOf<Result>()
                response.body()?.results?.forEach {  result ->
                    if(result.type?.lowercase() == "trailer"
                        && result.site?.lowercase() == "youtube" && result.official){
                        list.add(result)
                    }
                }
                videos.postValue(Resource.Success(list))
            }
        }catch(e: Exception){
        }
    }

    fun getMyRecommendation(type: String,id: Int) = viewModelScope.launch {
        if(type == "tv")
            getTmdbRecom(type,id)
        else{
            try {
                val response = repository.getMyRecom(id)
                if (response.isSuccessful){
                    recom.postValue(Resource.Success(response.body()!!))
                }else{
                    // If movie is not in our model then as fall back we'll use tmdb api
                    getTmdbRecom(type, id)
                }
            }catch(e: Exception){
                getTmdbRecom(type, id)
            }
        }
    }

    private fun getTmdbRecom(type: String, id: Int) = viewModelScope.launch {
        try {
            val response = repository.getRecom(type,id)
            if (response.isSuccessful){
                tmdbRecom.postValue(Resource.Success(response.body()!!.results))
            }
        }catch(e: Exception){
            e.printStackTrace()
        }
    }

    fun  insertMovie(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertMovie(movie)
    }


}