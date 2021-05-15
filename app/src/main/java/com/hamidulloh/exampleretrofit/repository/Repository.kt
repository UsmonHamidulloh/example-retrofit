package com.hamidulloh.exampleretrofit.repository

import com.hamidulloh.exampleretrofit.api.RetrofitInstance
import com.hamidulloh.exampleretrofit.model.Post
import okhttp3.internal.http.hasBody
import retrofit2.Response

class Repository {
    suspend fun getPost(): Post {
        val response = RetrofitInstance.api.getPost()
        if (response.isSuccessful) {
            val post = response.body()
            if (post != null) {
                return post
            }
        }

        return Post(
            userId = 0,
            id = 0,
            title = "error",
            body = "error"
        )

    }
}