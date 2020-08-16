package com.example.covidstats.network

import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Failure
import com.example.covidstats.model.Success
import com.example.covidstats.model.Result

class CovidAPI (private val apiService: CovidAPIService) {

    suspend fun getStatusSummary(): Result<CovidStatusSummary> = try {

        val villains = apiService.getStatusSummary()
        Success(villains)

    } catch (error: Throwable) {
        Failure(error)
    }
}