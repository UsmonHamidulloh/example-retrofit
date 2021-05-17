package com.hamidulloh.exampleretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamidulloh.exampleretrofit.model.Comment
import com.hamidulloh.exampleretrofit.repository.Repository
import kotlinx.coroutines.launch

class CommentsViewModel(val repository: Repository) : ViewModel() {
    val commentList: MutableLiveData<List<Comment>> = MutableLiveData()

    fun getCommentList(postId: Int) {
        viewModelScope.launch {
            commentList.value = repository.getCommentList(postId)
        }
    }

}