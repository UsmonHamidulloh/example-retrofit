package com.hamidulloh.exampleretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Comment
import com.hamidulloh.exampleretrofit.model.Post
import com.hamidulloh.exampleretrofit.repository.Repository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: Repository): ViewModel() {
    val postList: MutableLiveData<List<Post>> = MutableLiveData()
    val albumList: MutableLiveData<List<Album>> = MutableLiveData()
    val postResponse: MutableLiveData<Post> = MutableLiveData()

    init {
        getPostList()
        getAlbumList()
    }

    private fun getPostList() {
        viewModelScope.launch {
            postList.value = repository.getPostList()
        }
    }

    private fun getAlbumList() {
        viewModelScope.launch {
            albumList.value = repository.getAlbumList()
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            postResponse.value = repository.pushPost(post)
        }
    }



}