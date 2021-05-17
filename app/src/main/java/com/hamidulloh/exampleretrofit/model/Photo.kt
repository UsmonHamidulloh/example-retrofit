package com.hamidulloh.exampleretrofit.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("albumId")
    val album_id: Int,

    @SerializedName("id")
    val photo_id: Int,

    @SerializedName("url")
    val url: String,

    @SerializedName("thumbnailUrl")
    val thumbnail_url: String
)