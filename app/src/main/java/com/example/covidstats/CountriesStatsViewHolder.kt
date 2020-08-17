package com.example.covidstats

import androidx.recyclerview.widget.RecyclerView
import com.example.covidstats.databinding.CountriesStatsItemBinding
import com.example.covidstats.model.Country

class CountriesStatsViewHolder(private val binding: CountriesStatsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(country: Country) = with(binding) {
           binding.confirmedCases.text = country.TotalConfirmed.toString()
           binding.deathCases.text = country.TotalDeaths.toString()
           binding.recoveredCases.text = country.TotalRecovered.toString()
           binding.countryName.text = country.Country
    }
}