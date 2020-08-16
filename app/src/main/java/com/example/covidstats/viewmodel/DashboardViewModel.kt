package com.example.covidstats.viewmodel

import androidx.lifecycle.*
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result
import com.example.covidstats.repository.StatusRepository

class DashboardViewModel(private val statusRepository: StatusRepository) : ViewModel() {

    val summary: LiveData<Result<CovidStatusSummary>> = liveData {
        emit(statusRepository.getStatusSummary())
    }
}