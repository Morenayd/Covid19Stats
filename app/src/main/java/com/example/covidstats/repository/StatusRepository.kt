package com.example.covidstats.repository

import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result

interface StatusRepository {
    suspend fun getStatusSummary() : Result<CovidStatusSummary>
    fun insertStatusSummary()
}