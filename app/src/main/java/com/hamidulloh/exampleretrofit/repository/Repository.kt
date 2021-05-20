package com.hamidulloh.exampleretrofit.repository

import com.hamidulloh.exampleretrofit.api.RetrofitInstance
import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Comment
import com.hamidulloh.exampleretrofit.model.Photo
import com.hamidulloh.exampleretrofit.model.Post

class Repository(private val retrofitInstance: RetrofitInstance) {
    suspend fun getPostList(): List<Post> {
        val response = retrofitInstance.api.getPostList()
        val postList = ArrayList<Post>()

        if (response.isSuccessful) {
            response.body()?.forEach { post ->
                postList.add(post)
            }

        }
        return postList
    }

    suspend fun getAlbumList(): List<Album> {
        val response = retrofitInstance.api.getAlbumList()
        val albumList = ArrayList<Album>()

        if (response.isSuccessful) {
            response.body()?.forEach { album ->
                albumList.add(album)
            }

        }
        return albumList
    }

    suspend fun getCommentList(postId: Int): List<Comment> {
        val response = retrofitInstance.api.getCommentList(postId)
        val commentList = ArrayList<Comment>()

        if (response.isSuccessful) {
            response.body()?.forEach { comment ->
                commentList.add(comment)
            }
        }

        return commentList
    }

    suspend fun getPhotoList(albumId: Int): List<Photo> {
        val response = retrofitInstance.api.getPhotoList(albumId)
        val photoList = ArrayList<Photo>()

        if (response.isSuccessful) {
            response.body()?.forEach { photo ->
                photoList.add(photo)
            }
        }

        return photoList
    }
}