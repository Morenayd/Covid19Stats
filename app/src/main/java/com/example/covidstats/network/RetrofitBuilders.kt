package com.example.covidstats.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

const val BASE_URL = "https://api.covid19api.com/"

fun buildClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            //Log the body of the sent and received data
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

fun buildRetrofit(): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(buildClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.nonstrict.asConverterFactory(contentType))
        .build()
}

fun buildAPIService(): CovidAPIService = buildRetrofit().create(CovidAPIService::class.java)