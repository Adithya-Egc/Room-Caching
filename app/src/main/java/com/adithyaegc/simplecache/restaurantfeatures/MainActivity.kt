package com.adithyaegc.simplecache.restaurantfeatures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adithyaegc.simplecache.ExampleSingleton
import com.adithyaegc.simplecache.data.Restaurant
import com.adithyaegc.simplecache.databinding.ActivityMainBinding
import com.adithyaegc.simplecache.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var restaurantViewModel: RestaurantViewModel
    private val restaurantAdapter: RestaurantAdapter by lazy { RestaurantAdapter() }

    val userOne = ExampleSingleton.restaurantOne

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        restaurantViewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        binding.apply {
            rView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            restaurantViewModel.restaurants.observe(this@MainActivity) { restaurant ->
                restaurantAdapter.submitList(restaurant.data)

                progressBar.isVisible =
                    restaurant is Resource.Loading && restaurant.data.isNullOrEmpty()
                errorTextView.isVisible =
                    restaurant is Resource.Error && restaurant.data.isNullOrEmpty()
                errorTextView.text = restaurant.error?.localizedMessage
            }


        }


    }
}