package com.example.covidstats.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.covidstats.model.Country

@Dao
interface CovidStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryStats(countries: List<Country?>)

    @Query("SELECT * FROM country_table WHERE Country LIKE :searchString")
    fun getSearchAllCountries(searchString: String): LiveData<List<Country?>>
}