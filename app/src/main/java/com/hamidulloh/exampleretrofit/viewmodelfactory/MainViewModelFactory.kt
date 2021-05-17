package com.hamidulloh.exampleretrofit.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.viewmodel.CommentsViewModel
import com.hamidulloh.exampleretrofit.viewmodel.ListViewModel

class MainViewModelFactory(private val repository: Repository, val whichViewModel: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when (whichViewModel) {
            1 -> return CommentsViewModel(repository) as T
            2 -> return ListViewModel(repository) as T
        }

        return ListViewModel(repository) as T
    }

}