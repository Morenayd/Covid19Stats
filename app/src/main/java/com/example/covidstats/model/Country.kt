package com.example.covidstats.model

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class Country (
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val Slug: String,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)