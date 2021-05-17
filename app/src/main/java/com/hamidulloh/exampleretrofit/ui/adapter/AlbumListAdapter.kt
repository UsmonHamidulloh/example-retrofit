package com.hamidulloh.exampleretrofit.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamidulloh.exampleretrofit.databinding.ItemAlbumBinding
import com.hamidulloh.exampleretrofit.model.Album

class AlbumListAdapter : ListAdapter<Album, AlbumListAdapter.ViewHolder>(AlbumListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = getItem(position)

        holder.binding.apply {
            userId.text = "user_id: ${album.user_id}"
            albumId.text = "album_id: ${album.album_id}"
            title.text = album.title
        }
    }

    class AlbumListDiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.album_id == newItem.album_id
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root)
}