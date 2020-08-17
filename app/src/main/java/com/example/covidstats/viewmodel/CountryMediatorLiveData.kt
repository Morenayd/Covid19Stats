package com.example.covidstats.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class CountryMediatorLiveData<T>(query: LiveData<T>) : MediatorLiveData<T?>() {
    init {
        addSource(query) {
            value = query.value
        }
    }
}
