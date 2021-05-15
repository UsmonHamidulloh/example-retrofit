package com.hamidulloh.exampleretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamidulloh.exampleretrofit.model.Post
import com.hamidulloh.exampleretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val myPost: MutableLiveData<Post> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myPost.value = repository.getPost()
        }
    }
}