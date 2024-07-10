package com.example.learningretrofit.data

sealed class Result<T> (
    val data: T? = null,
    val message: String? = null
) {
    //If the API is called successfully
    class Success<T> (data: T?) : Result<T> (data)

    //If the API is not called successfully
    class Error<T> (data: T? = null, message: String) : Result<T> (data, message)
}