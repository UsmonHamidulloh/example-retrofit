package com.hamidulloh.exampleretrofit.api

import com.hamidulloh.exampleretrofit.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: JsonHolderApi by lazy {
        retrofit.create(JsonHolderApi::class.java)
    }
}