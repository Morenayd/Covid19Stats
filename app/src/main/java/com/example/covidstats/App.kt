package com.example.covidstats

import android.app.Application
import android.content.Context
import com.example.covidstats.database.CovidStatusDao
import com.example.covidstats.database.CovidStatusDatabase
import com.example.covidstats.network.CovidAPI
import com.example.covidstats.network.buildAPIService

class App : Application() {
    companion object {
        private lateinit var instance: App

        fun getApplicationContext(): Context = instance.applicationContext
        private val apiService by lazy { buildAPIService() }
        val statusAPI by lazy { CovidAPI(apiService) }
        lateinit var statusDao: CovidStatusDao
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        statusDao = CovidStatusDatabase.getInstance(this).statusDao()

    }
}
