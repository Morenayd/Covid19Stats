package com.example.covidstats.repository

import androidx.lifecycle.LiveData
import com.example.covidstats.model.Country
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result

interface StatusRepository {
    suspend fun getStatusSummary() : Result<CovidStatusSummary>
    fun insertCountryStats(countries: List<Country?>)
    fun getSearchAllCountries(searchQuery: String?): LiveData<List<Country?>>
}