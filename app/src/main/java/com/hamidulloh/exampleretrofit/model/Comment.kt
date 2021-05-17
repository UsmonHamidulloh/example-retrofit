package com.hamidulloh.exampleretrofit.model

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("postId")
    val postId: Int,

    @SerializedName("id")
    val commentId: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("body")
    val body: String
)