package com.example.covidstats.viewmodel

import androidx.lifecycle.*
import com.example.covidstats.model.Country
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result
import com.example.covidstats.repository.StatusRepository

class DashboardViewModel(private val statusRepository: StatusRepository) : ViewModel() {

    val summary: LiveData<Result<CovidStatusSummary>> = liveData {
        emit(statusRepository.getStatusSummary())
    }

    fun insertCountryStats(countries: List<Country?>) {
        statusRepository.insertCountryStats(countries)
    }

    val countryStats: LiveData<List<com.example.covidstats.database.localmodel.Country?>> = liveData {
        emit(statusRepository.getCountryStats())
    }
}