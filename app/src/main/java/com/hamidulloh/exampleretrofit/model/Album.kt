package com.hamidulloh.exampleretrofit.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("userId")
    val user_id: Int,

    @SerializedName("id")
    val album_id: Int,

    @SerializedName("title")
    val title: String
)
