package com.hamidulloh.exampleretrofit.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.exampleretrofit.dagger.component.DaggerMainComponent
import com.hamidulloh.exampleretrofit.databinding.FragmentAddPostBinding
import com.hamidulloh.exampleretrofit.model.Post
import com.hamidulloh.exampleretrofit.viewmodel.ListViewModel
import com.hamidulloh.exampleretrofit.viewmodelfactory.MainViewModelFactory
import timber.log.Timber

class AddPostFragment : Fragment() {
    private var _binding: FragmentAddPostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPostBinding.inflate(inflater, container, false)

        val repository = DaggerMainComponent.create().createRepository()
        val viewModelFactory = MainViewModelFactory(repository, 1)
        val viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(ListViewModel::class.java)

        binding.postBtn.setOnClickListener {
            val post = Post(
                post_id = Integer.valueOf(binding.postId.text.toString()),
                user_id = Integer.valueOf(binding.userId.text.toString()),
                title = binding.title.text.toString(),
                body = binding.body.text.toString()
            )

            viewModel.pushPost(post)

            viewModel.postResponse.observe(requireActivity(), { postResponse ->
                Toast.makeText(requireContext(), postResponse.toString(), Toast.LENGTH_LONG).show()
            })

            binding.userId.text.clear()
            binding.postId.text.clear()
            binding.title.text.clear()
            binding.body.text.clear()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}