package com.example.nopyjf.models.landing

import com.google.gson.annotations.SerializedName

data class LandingEntity(
    @SerializedName("title") val title: String? = null,
    @SerializedName("image") val image: String? = null,
)