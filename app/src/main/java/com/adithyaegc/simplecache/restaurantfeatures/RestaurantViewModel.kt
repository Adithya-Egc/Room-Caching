package com.adithyaegc.simplecache.restaurantfeatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adithyaegc.simplecache.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(private val repository: RestaurantRepository) :
    ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()




//    private val _restaurantResponse: MutableLiveData<List<Restaurant>> = MutableLiveData()
//    val restaurantResponse: LiveData<List<Restaurant>> = _restaurantResponse
//
//
//    init {
//        viewModelScope.launch {
//            val response = api.getRestaurants()
//            delay(2000)
//            _restaurantResponse.value = response
//        }
//    }
}


