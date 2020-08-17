package com.example.covidstats.repository

import com.example.covidstats.model.Country
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result

interface StatusRepository {
    suspend fun getStatusSummary() : Result<CovidStatusSummary>
    fun insertCountryStats(countries: List<Country?>)
    fun getCountryStats(): List<com.example.covidstats.database.localmodel.Country?>
}