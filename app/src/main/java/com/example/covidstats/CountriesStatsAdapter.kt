package com.example.covidstats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CountriesStatsAdapter(private val countriesStats: List<CountryStats>): RecyclerView.Adapter<CountriesStatsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesStatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.countries_stats_item, parent, false)
        return CountriesStatsViewHolder(view)
    }

    override fun getItemCount() = countriesStats.size

    override fun onBindViewHolder(holder: CountriesStatsViewHolder, position: Int) {
    }

}