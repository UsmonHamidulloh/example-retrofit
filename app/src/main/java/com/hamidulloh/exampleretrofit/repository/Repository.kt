package com.hamidulloh.exampleretrofit.repository

import com.hamidulloh.exampleretrofit.api.RetrofitInstance
import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Post

class Repository {
    suspend fun getPostList(): List<Post> {
        val response = RetrofitInstance.api.getPostList()
        val postList = ArrayList<Post>()

        if (response.isSuccessful) {
            response.body()?.forEach { post ->
                postList.add(post)
            }

        }
        return postList
    }

    suspend fun getAlbumList(): List<Album> {
        val response = RetrofitInstance.api.getAlbums()
        val albumList = ArrayList<Album>()

        if (response.isSuccessful) {
            response.body()?.forEach { album ->
                albumList.add(album)
            }

        }
        return albumList
    }
}