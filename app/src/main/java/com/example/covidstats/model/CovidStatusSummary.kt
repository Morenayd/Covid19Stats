package com.example.covidstats.model

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class CovidStatusSummary (
    val Countries: List<Country>,
    val Date: String,
    val Global: Global
)