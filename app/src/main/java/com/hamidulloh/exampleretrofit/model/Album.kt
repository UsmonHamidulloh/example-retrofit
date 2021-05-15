package com.hamidulloh.exampleretrofit.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val albumId: Int,

    @SerializedName("title")
    val title: String
)
