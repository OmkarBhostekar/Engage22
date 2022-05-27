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

    fun getTopRated() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getTopRated()
            if (response.isSuccessful && response.body() != null)
                topRated.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getContentBased(movieId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getContentBased(movieId)
            if (response.isSuccessful && response.body() != null)
                contentBased.postValue(Resource.Success(response.body()!!))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}