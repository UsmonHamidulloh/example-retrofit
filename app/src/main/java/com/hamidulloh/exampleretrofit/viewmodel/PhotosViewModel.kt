package com.hamidulloh.exampleretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamidulloh.exampleretrofit.model.Photo
import com.hamidulloh.exampleretrofit.repository.Repository
import kotlinx.coroutines.launch

class PhotosViewModel(private val repository: Repository) : ViewModel() {
    val photoList: MutableLiveData<List<Photo>> = MutableLiveData()

    fun getPhotoList(albumId: Int) {
        viewModelScope.launch {
            photoList.value = repository.getPhotoList(albumId)
        }
    }
}