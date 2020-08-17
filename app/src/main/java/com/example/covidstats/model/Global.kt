package com.example.covidstats.model

import kotlinx.serialization.Serializable

@Serializable
data class Global (
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)