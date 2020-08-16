package com.example.covidstats.database.localmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Global (
    val newConfirmed: Int,
    val newDeaths: Int,
    val newRecovered: Int,
    val totalConfirmed: Int,
    val totalDeaths: Int,
    val totalRecovered: Int
) : Parcelable