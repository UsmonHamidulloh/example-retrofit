package com.hamidulloh.exampleretrofit.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.viewmodel.CommentsViewModel
import com.hamidulloh.exampleretrofit.viewmodel.ListViewModel
import com.hamidulloh.exampleretrofit.viewmodel.PhotosViewModel

class MainViewModelFactory(
    private val repository: Repository,
    private val whichViewModel: Int
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when (whichViewModel) {
            1 -> ListViewModel(repository) as T
            2 -> CommentsViewModel(repository) as T
            3 -> PhotosViewModel(repository) as T

            else -> throw IllegalArgumentException("unknown viewModel")
        }
    }

}

/**
 * 1 viewModel for postList and albumList viewModels
 * 2 viewModel for only CommentList [GET("comments?postId={id})]
 * 3 viewModel for only PhotoList [GET("photos?albumId={id}]
 * */
