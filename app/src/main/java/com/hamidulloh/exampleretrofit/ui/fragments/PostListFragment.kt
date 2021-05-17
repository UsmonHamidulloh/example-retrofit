package com.hamidulloh.exampleretrofit.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.exampleretrofit.databinding.FragmentPostListBinding
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.ui.adapter.PostListAdapter
import com.hamidulloh.exampleretrofit.viewmodel.ListViewModel
import com.hamidulloh.exampleretrofit.viewmodelfactory.MainViewModelFactory

class PostListFragment : Fragment() {
    private var _binding: FragmentPostListBinding? = null
    private val binding get() = _binding!!

    private val myTag = "PostListFragment"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostListBinding.inflate(inflater, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository, 2)
        val viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(ListViewModel::class.java)

        val postAdapter = PostListAdapter(PostListAdapter.PostItemCallBack { post ->
            val navDirections = PostListFragmentDirections
                .actionPostListFragmentToPostFragment(postId = post.post_id)
            findNavController().navigate(navDirections)
        })

        viewModel.postList.observe(requireActivity(), { postList ->
            postAdapter.submitList(postList)
            Log.d(myTag, "onCreateView: $postList")
        })

        binding.postList.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}