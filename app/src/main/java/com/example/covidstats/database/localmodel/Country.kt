package com.example.covidstats.database.localmodel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country (
    var country: String,
    var countryCode: String,
    var date: String,
    var newConfirmed: Int,
    var newDeaths: Int,
    var newRecovered: Int,
    var slug: String,
    var totalConfirmed: Int,
    var totalDeaths: Int,
    var totalRecovered: Int
) : Parcelable