package com.example.learningretrofit.data

import com.example.learningretrofit.data.model.Products
import retrofit2.http.GET

interface Api {
    @GET("products")
    suspend fun getProductsList() : Products

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}