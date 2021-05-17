package com.hamidulloh.exampleretrofit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.exampleretrofit.databinding.FragmentAlbumListBinding
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.ui.adapter.AlbumListAdapter
import com.hamidulloh.exampleretrofit.viewmodel.ListViewModel
import com.hamidulloh.exampleretrofit.viewmodelfactory.MainViewModelFactory

class AlbumListFragment : Fragment() {
    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository, 2)
        val viewModel = ViewModelProvider(requireActivity(),
            viewModelFactory).get(ListViewModel::class.java)
        val albumAdapter = AlbumListAdapter()

        viewModel.albumList.observe(requireActivity(), { albumList ->
            albumAdapter.submitList(albumList)
        })

        binding.albumList.apply {
            adapter = albumAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}