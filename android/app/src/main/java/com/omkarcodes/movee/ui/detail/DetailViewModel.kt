package com.omkarcodes.movee.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.detail.models.movie.MovieDetail
import com.omkarcodes.movee.ui.detail.models.tv.Cast
import com.omkarcodes.movee.ui.detail.models.tv.TvDetail
import com.omkarcodes.movee.ui.detail.models.video.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel(){

    val movieDetail = MutableLiveData<Resource<MovieDetail>>(Resource.Empty())
    val tvDetail = MutableLiveData<Resource<TvDetail>>(Resource.Empty())
    val cast = MutableLiveData<Resource<List<Cast>>>(Resource.Empty())
    val videos = MutableLiveData<Resource<List<Result>>>(Resource.Empty())

    fun getMovieDetail(movieId: Int) = viewModelScope.launch {
        try{
            val response = repository.getMovieDetail(movieId)
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

    fun  insertMovie(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertMovie(movie)
    }


}