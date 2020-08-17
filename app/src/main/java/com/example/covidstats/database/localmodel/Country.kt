package com.example.covidstats.database.localmodel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "country_table")
data class Country (
    @PrimaryKey
    val country: String,
    val countryCode: String,
    val date: String,
    val newConfirmed: Int,
    val newDeaths: Int,
    val newRecovered: Int,
    val slug: String,
    val totalConfirmed: Int,
    val totalDeaths: Int,
    val totalRecovered: Int
) : Parcelable