package com.example.covidstats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.covidstats.databinding.CountriesStatsItemBinding
import com.example.covidstats.model.Country

class CountriesStatsAdapter :
    ListAdapter<Country, CountriesStatsViewHolder>(DIFFUTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesStatsViewHolder {
        val binding = CountriesStatsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CountriesStatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesStatsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DIFFUTIL : DiffUtil.ItemCallback<Country>() {

        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.CountryCode == newItem.CountryCode
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.equals(newItem)
        }

    }
}