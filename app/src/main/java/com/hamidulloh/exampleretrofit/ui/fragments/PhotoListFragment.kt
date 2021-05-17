package com.hamidulloh.exampleretrofit.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.exampleretrofit.databinding.FragmentPhotoListBinding
import com.hamidulloh.exampleretrofit.repository.Repository
import com.hamidulloh.exampleretrofit.ui.adapter.PhotoListAdapter
import com.hamidulloh.exampleretrofit.utils.Constants.Companion.BASE_URL
import com.hamidulloh.exampleretrofit.viewmodel.PhotosViewModel
import com.hamidulloh.exampleretrofit.viewmodelfactory.MainViewModelFactory

class PhotoListFragment : Fragment() {
    private var _binding: FragmentPhotoListBinding? = null
    private val binding get() = _binding!!

    private val safeArgs: PhotoListFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoListBinding.inflate(inflater, container, false)

        val repository = Repository()
        val photoListAdapter = PhotoListAdapter()
        val viewModelFactory = MainViewModelFactory(repository, 3)
        val viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        )[PhotosViewModel::class.java]

        viewModel.getPhotoList(safeArgs.albumId)
        viewModel.photoList.observe(requireActivity(), { photos ->
            photoListAdapter.submitList(photos)
        })

        binding.photoList.apply {
            adapter = photoListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.url.text = "${BASE_URL}/photos?albumId=${safeArgs.albumId}"

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}