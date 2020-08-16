package com.example.covidstats.network

import com.example.covidstats.model.CovidStatusSummary
import retrofit2.http.GET

interface CovidAPIService {

    @GET("summary")
    suspend fun getStatusSummary(): CovidStatusSummary

}