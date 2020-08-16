package com.example.covidstats.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.covidstats.App
import com.example.covidstats.model.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel: ViewModel() {
    val api = App.statusAPI

    suspend fun getStatusSummary() =
        CoroutineScope(Dispatchers.Main).launch {
        val result = api.getStatusSummary()

        if (result is Success) {
            var summary = result.data    

        } else {
            Toast.makeText(App.getApplicationContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show()
        }
    }

}