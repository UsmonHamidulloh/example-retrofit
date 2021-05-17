package com.hamidulloh.exampleretrofit.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hamidulloh.exampleretrofit.databinding.ItemPhotoBinding
import com.hamidulloh.exampleretrofit.model.Photo

class PhotoListAdapter : ListAdapter<Photo, PhotoListAdapter.ViewHolder>(PhotoListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val _binding = ItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ViewHolder(_binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = getItem(position)

        holder.binding.apply {
            Glide
                .with(root)
                .load(photo.thumbnail_url)
                .into(image)

            photoId.text = "photo_id: ${photo.photo_id}"
        }
    }

    class PhotoListDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.photo_id == newItem.photo_id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)
}