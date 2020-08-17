package com.example.covidstats.repository

import androidx.lifecycle.LiveData
import com.example.covidstats.database.CovidStatusDao
import com.example.covidstats.model.Country
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result
import com.example.covidstats.model.Result.Failure
import com.example.covidstats.model.Result.Success
import com.example.covidstats.network.CovidAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class StatusRepositoryImpl(private val service: CovidAPIService, private val dao: CovidStatusDao) : StatusRepository {

    override suspend fun getStatusSummary(): Result<CovidStatusSummary> {
        return try {
            Success(service.getStatusSummary())
        } catch (exception: IOException) {
            return Failure(exception.cause)
        } catch (exception: HttpException) {
            return Failure(exception.cause)
        }
    }

    override fun insertCountryStats(countries: List<Country?>) {
        CoroutineScope(Dispatchers.Main).launch {
            dao.insertCountryStats(countries)
        }
    }

    override fun getSearchAllCountries(searchQuery: String?): LiveData<List<Country?>> {
        return dao.getSearchAllCountries("%$searchQuery%")
    }
}