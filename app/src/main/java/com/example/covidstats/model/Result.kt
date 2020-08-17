package com.example.covidstats.model

sealed class Result<out T : Any> {
    data class Loading(val message: String) : Result<Nothing>()

    data class Success<T : Any>(val data: T) : Result<T>()

    data class Failure(val error: Throwable?) : Result<Nothing>()
}