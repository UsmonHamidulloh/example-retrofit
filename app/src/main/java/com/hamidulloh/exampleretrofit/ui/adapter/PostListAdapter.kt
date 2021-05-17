package com.hamidulloh.exampleretrofit.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamidulloh.exampleretrofit.databinding.ItemPostBinding
import com.hamidulloh.exampleretrofit.model.Post

class PostListAdapter(
    val itemClickListener: PostItemCallBack
) : ListAdapter<Post, PostListAdapter.ViewHolder>(PostListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(
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
            postId.text = "postId: ${post.id}"
            title.text = post.title
            body.text = post.body

            root.setOnClickListener {
                itemClickListener.onItemClick(post)
            }
        }


    }

    class PostItemCallBack(val itemClickListener: (item: Post) -> Unit) {
        fun onItemClick(item: Post) = itemClickListener(item)
    }

    class PostListDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)
}