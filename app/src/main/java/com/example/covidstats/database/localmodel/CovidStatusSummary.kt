package com.example.covidstats.database.localmodel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "status_table")
data class CovidStatusSummary (
    val countries: List<Country>,
    @PrimaryKey
    val date: String,
    val global: Global
): Parcelable