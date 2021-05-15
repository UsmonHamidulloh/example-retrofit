package com.hamidulloh.exampleretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Post
import com.hamidulloh.exampleretrofit.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    val postList: MutableLiveData<List<Post>> = MutableLiveData()
    val albumList: MutableLiveData<List<Album>> = MutableLiveData()

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
}