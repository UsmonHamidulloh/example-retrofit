package com.hamidulloh.exampleretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.exampleretrofit.databinding.ActivityMainBinding
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.viewmodel.MainViewModel
import com.hamidulloh.exampleretrofit.viewmodelfactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = Repository()
        val viewModelFactory = MainViewModelFactory(repository = repo)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.myPost.observe(this, { post ->
            binding.apply {
                userId.text = "userId: ${post.userId}"
                postId.text = "postId: ${post.id}"
                title.text = "title: ${post.title}"
                body.text = "body: ${post.body}"
            }
        })
    }
}