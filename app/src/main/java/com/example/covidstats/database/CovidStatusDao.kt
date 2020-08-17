package com.example.covidstats.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.covidstats.model.Country

@Dao
interface CovidStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryStats(countries: List<Country?>)

    @Query("SELECT * FROM country_table ORDER BY country ASC")
    suspend fun getCountryStats(): List<Country?>
}