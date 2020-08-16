package com.example.covidstats.repository

interface StatusRepository {
    fun getStatusSummary()
    fun insertStatusSummary()
}