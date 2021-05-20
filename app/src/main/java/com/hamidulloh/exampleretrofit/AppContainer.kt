package com.hamidulloh.exampleretrofit

import com.hamidulloh.exampleretrofit.api.RetrofitInstance
import com.hamidulloh.exampleretrofit.repository.Repository

class AppContainer {
    private val retrofitInstance = RetrofitInstance

    val repository = Repository(retrofitInstance)
}