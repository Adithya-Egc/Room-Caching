package com.adithyaegc.simplecache.restaurantfeatures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adithyaegc.simplecache.databinding.RowItemLayoutBinding
import com.adithyaegc.simplecache.data.Restaurant
import com.bumptech.glide.Glide

class RestaurantAdapter :
    ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view =
            RowItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)

    }

    class RestaurantViewHolder(private val binding: RowItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(ivLogo)

                tvName.text = restaurant.name
                tvAddress.text = restaurant.address
                tvType.text = restaurant.type
            }
        }
    }

    class RestaurantDiffUtil : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }
}