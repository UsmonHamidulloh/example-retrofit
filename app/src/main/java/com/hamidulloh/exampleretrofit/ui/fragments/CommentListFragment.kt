package com.hamidulloh.exampleretrofit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.exampleretrofit.MyApplication
import com.hamidulloh.exampleretrofit.databinding.FragmentCommentListBinding
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.ui.adapter.CommentListAdapter
import com.hamidulloh.exampleretrofit.utils.Constants.Companion.BASE_URL
import com.hamidulloh.exampleretrofit.viewmodel.CommentsViewModel
import com.hamidulloh.exampleretrofit.viewmodelfactory.MainViewModelFactory

class CommentListFragment : Fragment() {
    private var _binding: FragmentCommentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CommentsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentListBinding.inflate(inflater, container, false)
        val appContainer = (requireActivity().application as MyApplication).appContainer

        val repository = appContainer.repository
        val viewModelFactory = MainViewModelFactory(repository, 2)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(CommentsViewModel::class.java)
        val args: CommentListFragmentArgs by navArgs()
        val commentListAdapter = CommentListAdapter()

        viewModel.commentList.observe(requireActivity(), { comments ->
            commentListAdapter.submitList(comments)
        })

        binding.commentList.apply {
            adapter = commentListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.url.text = "${BASE_URL}/comments?postId=${args.postId}"

        viewModel.getCommentList(args.postId)
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        viewModel.commentList.value = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}