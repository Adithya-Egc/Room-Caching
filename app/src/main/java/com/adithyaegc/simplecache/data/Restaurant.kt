package com.adithyaegc.simplecache.data


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class Restaurant(
    val address: String,
    val logo: String,
    @PrimaryKey val name: String,
    val type: String
) {
}