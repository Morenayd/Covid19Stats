package com.example.covidstats.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "country_table")
data class Country(
    @PrimaryKey
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
) {
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Country

        if (Country != other.Country) return false
        if (CountryCode != other.CountryCode) return false
        if (Date != other.Date) return false
        if (NewConfirmed != other.NewConfirmed) return false
        if (NewDeaths != other.NewDeaths) return false
        if (NewRecovered != other.NewRecovered) return false
        if (Slug != other.Slug) return false
        if (TotalConfirmed != other.TotalConfirmed) return false
        if (TotalDeaths != other.TotalDeaths) return false
        if (TotalRecovered != other.TotalRecovered) return false

        return true
    }
}