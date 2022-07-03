package com.adithyaegc.simplecache

import com.adithyaegc.simplecache.data.Restaurant

object ExampleSingleton {

    val restaurantOne: Restaurant by lazy {
        Restaurant("one123", "myLogo", "adithya", "male")
    }
}