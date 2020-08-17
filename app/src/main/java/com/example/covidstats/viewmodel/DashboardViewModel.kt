package com.example.covidstats.viewmodel

import androidx.lifecycle.*
import com.example.covidstats.model.Country
import com.example.covidstats.model.CovidStatusSummary
import com.example.covidstats.model.Result
import com.example.covidstats.repository.StatusRepository

class DashboardViewModel(private val statusRepository: StatusRepository) : ViewModel() {
    private val _searchQuery = MutableLiveData("")
    val countries: LiveData<List<Country?>>

    init {
        countries = Transformations.switchMap(CountryMediatorLiveData(_searchQuery)) {
            statusRepository.getSearchAllCountries(it)
        }
    }

    val summary: LiveData<Result<CovidStatusSummary>> = liveData {
        emit(statusRepository.getStatusSummary())
    }

    fun insertCountryStats(countries: List<Country?>) {
        statusRepository.insertCountryStats(countries)
    }

    fun getSearchResults(searchString: String?) {
        _searchQuery.value = searchString
    }
}