package com.omkarcodes.movee.ui.recommendation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.recommendation.models.RecMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendationViewModel @Inject constructor(
    private val repository: RecommendationRepository
) : ViewModel() {

    val topRated = MutableLiveData<Resource<List<RecMovie>>>()
    val contentBased = MutableLiveData<Resource<List<RecMovie>>>()
    val cfBased = MutableLiveData<Resource<List<RecMovie>>>()
    val gen1 = MutableLiveData<Resource<List<RecMovie>>>()
    val gen2 = MutableLiveData<Resource<List<RecMovie>>>()
    val gen3 = MutableLiveData<Resource<List<RecMovie>>>()

    fun getTopRated() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getTopRated()
            if (response.isSuccessful && response.body() != null)
                topRated.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getContentBased(tmdbId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getContentBased(tmdbId)
            if (response.isSuccessful && response.body() != null)
                contentBased.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getCFRecom(movieId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getCfRecom(movieId)
            if (response.isSuccessful && response.body() != null)
                cfBased.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getGen1(genre: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getByGenres(genre)
            if (response.isSuccessful && response.body() != null)
                gen1.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getGen2(genre: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getByGenres(genre)
            if (response.isSuccessful && response.body() != null)
                gen2.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getGen3(genre: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getByGenres(genre)
            if (response.isSuccessful && response.body() != null)
                gen3.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}