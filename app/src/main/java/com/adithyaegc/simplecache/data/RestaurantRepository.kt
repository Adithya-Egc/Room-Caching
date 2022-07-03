package com.adithyaegc.simplecache.data

import androidx.room.withTransaction
import com.adithyaegc.simplecache.api.RestaurantApi
import com.adithyaegc.simplecache.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {

    private val dao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = { dao.getAllRestaurants() },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                dao.deleteAllRestaurants()
                dao.insertRestaurants(restaurants)
            }
        }
    )

}