package com.hamidulloh.exampleretrofit.api

import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Comment
import com.hamidulloh.exampleretrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonHolderApi {
    @GET("posts")
    suspend fun getPostList(): Response<ArrayList<Post>>

    @GET("albums")
    suspend fun getAlbums(): Response<ArrayList<Album>>

    @GET("comments")
    suspend fun getComments(
        @Query("postId") postId: Int
    ): Response<List<Comment>>
}