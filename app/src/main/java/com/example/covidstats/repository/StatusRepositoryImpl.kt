package com.example.covidstats.repository

import android.widget.Toast
import com.example.covidstats.App
import com.example.covidstats.model.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatusRepositoryImpl: StatusRepository {
    val api = App.statusAPI

    override fun getStatusSummary() {
        TODO("Not yet implemented")
    }

    override fun insertStatusSummary() {
        suspend fun getStatusSummary() =
            CoroutineScope(Dispatchers.Main).launch {
                val result = api.getStatusSummary()

                if (result is Success) {
                    App.statusDao.insertCovidStatusData(result.data)
                } else {
                    Toast.makeText(App.getApplicationContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            }
    }
}