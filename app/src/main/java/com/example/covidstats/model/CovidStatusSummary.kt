package com.example.covidstats.model

data class CovidStatusSummary (
    val countries: List<Country>,
    val date: String,
    val global: Global
)