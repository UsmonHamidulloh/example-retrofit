package com.hamidulloh.exampleretrofit.api

import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Comment
import com.hamidulloh.exampleretrofit.model.Photo
import com.hamidulloh.exampleretrofit.model.Post
import retrofit2.Response
import retrofit2.http.*

interface JsonHolderApi {
    @GET("posts")
    suspend fun getPostList(): Response<ArrayList<Post>>

    @GET("albums")
    suspend fun getAlbumList(): Response<ArrayList<Album>>

    @GET("comments")
    suspend fun getCommentList(
        @Query("postId") postId: Int
    ): Response<List<Comment>>

    @GET("photos")
    suspend fun getPhotoList(
        @Query("albumId") albumId: Int
    ): Response<List<Photo>>

    @POST("posts")
    suspend fun sendingPost(
        @Body post: Post
    ): Response<Post>
}