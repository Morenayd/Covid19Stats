package com.example.covidstats

import android.app.Application
import android.content.Context
import com.example.covidstats.database.CovidStatusDao
import com.example.covidstats.database.CovidStatusDatabase
import com.example.covidstats.network.CovidAPI
import com.example.covidstats.network.buildAPIService
import com.example.covidstats.repository.StatusRepository
import com.example.covidstats.repository.StatusRepositoryImpl
import com.example.covidstats.viewmodel.ViewModelFactory

class App : Application() {
    companion object {
        private lateinit var instance: App
        private fun getAppContext(): Context = instance.applicationContext
        private val apiService by lazy { buildAPIService() }
        private val statusDao: CovidStatusDao by lazy {
            CovidStatusDatabase.getInstance(getAppContext()).statusDao()
        }

        fun provideViewModelFactory(): ViewModelFactory {
            return ViewModelFactory(StatusRepositoryImpl(apiService, statusDao))
        }
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}
