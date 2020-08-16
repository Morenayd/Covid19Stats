package com.example.covidstats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidstats.repository.StatusRepository

class ViewModelFactory(private val repository: StatusRepository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        with(modelClass) {
            if (isAssignableFrom(modelClass)) {
                return DashboardViewModel(repository) as T
            } else {
                throw IllegalArgumentException("ViewModel class (${modelClass.name}) is not mapped")
            }
        }
    }
}