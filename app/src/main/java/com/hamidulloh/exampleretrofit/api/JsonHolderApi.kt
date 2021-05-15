package com.hamidulloh.exampleretrofit.api

import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonHolderApi {
    @GET("posts")
    suspend fun getPostList(): Response<ArrayList<Post>>

    @GET("albums")
    suspend fun getAlbums(): Response<ArrayList<Album>>
}