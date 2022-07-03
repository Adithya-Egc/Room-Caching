package com.adithyaegc.simplecache.di

import android.app.Application
import androidx.room.Room
import com.adithyaegc.simplecache.api.RestaurantApi
import com.adithyaegc.simplecache.api.RestaurantApi.Companion.BASE_URL
import com.adithyaegc.simplecache.data.RestaurantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()


    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): RestaurantApi {
        return retrofit.create(RestaurantApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application) = Room.databaseBuilder(
        app,
        RestaurantDatabase::class.java,
        "restaurant_db"
    ).build()


}