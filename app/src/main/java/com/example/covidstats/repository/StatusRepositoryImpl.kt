package com.example.covidstats.repository

import com.example.covidstats.App
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result
import com.example.covidstats.model.Result.Failure
import com.example.covidstats.model.Result.Success
import com.example.covidstats.network.CovidAPIService
import retrofit2.HttpException
import java.io.IOException

class StatusRepositoryImpl(private val service: CovidAPIService): StatusRepository {
    val api = App.statusAPI

    override suspend fun getStatusSummary(): Result<CovidStatusSummary> {
        return try {
            Success(service.getStatusSummary())
        } catch (exception: IOException) {
            return Failure(exception.cause)
        } catch (exception: HttpException) {
            return Failure(exception.cause)
        }
    }

    override fun insertStatusSummary() {
        TODO("Not yet implemented")
    }

    /*override fun insertStatusSummary() {
        suspend fun getStatusSummary() =
            CoroutineScope(Dispatchers.Main).launch {
                val result = api.getStatusSummary()

                if (result is Success) {
                    App.statusDao.insertCovidStatusData(result.data)
                } else {
                    Toast.makeText(App.getApplicationContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            }
    }*/
}