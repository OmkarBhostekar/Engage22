package com.omkarcodes.movee.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkarcodes.movee.comman.toMovie
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.home.models.NetflixOg
import com.omkarcodes.movee.ui.home.models.PopularMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel(){

    val netflixOriginals = MutableLiveData<Resource<List<NetflixOg>>>()
    val popularMovies = MutableLiveData<Resource<List<PopularMovie>>>()
    val nowPlayingMovies = MutableLiveData<Resource<List<PopularMovie>>>()
    val mcuMovies = MutableLiveData<Resource<List<PopularMovie>>>()
    val popularTvShows = MutableLiveData<Resource<List<PopularMovie>>>()

    fun getNetflixOriginals() = viewModelScope.launch {
        try{
           if (netflixOriginals.value == null){
               val response = repository.getNetflixOg()
               if (response.isSuccessful)
                   netflixOriginals.postValue(Resource.Success(response.body()!!.results))
           }
        }catch(e: Exception){
        }
    }

    fun getPopularMovies() = viewModelScope.launch {
        try{
            if (popularMovies.value == null){
                val response = repository.getPopularMovies()
                if (response.isSuccessful)
                    popularMovies.postValue(Resource.Success(response.body()!!.results))
            }
        }catch(e: Exception){
        }
    }

    fun getNowPlayingMovies() = viewModelScope.launch {
        try{
            if (nowPlayingMovies.value == null){
                val response = repository.getNowPlayingMovies()
                if (response.isSuccessful)
                    nowPlayingMovies.postValue(Resource.Success(response.body()!!.results))
            }
        }catch(e: Exception){
        }
    }

    fun getMcuMovies() = viewModelScope.launch {
        try{
            if (mcuMovies.value == null){
                val response = repository.getMcuMovies()
                if (response.isSuccessful)
                    mcuMovies.postValue(Resource.Success(response.body()!!.results))
            }
        }catch(e: Exception){
        }
    }

    fun getPopularTvShows() = viewModelScope.launch {
        try{
            if (popularTvShows.value == null){
                val response = repository.getPopularTvShows()
                if (response.isSuccessful)
                    popularTvShows.postValue(Resource.Success(response.body()!!.results.map {
                        it.toMovie()
                    }))
            }
        }catch(e: Exception){
        }
    }


}