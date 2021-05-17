package com.hamidulloh.exampleretrofit.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val user_id: Int,

    @SerializedName("id")
    val post_id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
)