package com.hamidulloh.exampleretrofit.api

import com.hamidulloh.exampleretrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonHolderApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>
}