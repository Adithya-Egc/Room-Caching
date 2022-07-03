package com.adithyaegc.simplecache.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant_table")
    fun getAllRestaurants(): Flow<List<Restaurant>>

    @Insert
    suspend fun insertRestaurants(restaurant: List<Restaurant>)

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAllRestaurants()


}