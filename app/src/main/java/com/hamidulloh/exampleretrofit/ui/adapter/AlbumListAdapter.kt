package com.hamidulloh.exampleretrofit.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamidulloh.exampleretrofit.databinding.ItemAlbumBinding
import com.hamidulloh.exampleretrofit.model.Album
import com.hamidulloh.exampleretrofit.model.Post

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
        val post = getItem(position)

        holder.binding.apply {
            userId.text = "userId: ${post.userId}"
            albumId.text = "albumId: ${post.albumId}"
            title.text = post.title
        }
    }

    class AlbumListDiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.albumId == newItem.albumId
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root)
}