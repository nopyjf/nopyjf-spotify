package com.example.nopyjf.models.landing

import com.google.gson.annotations.SerializedName

data class LandingListEntity(
    @SerializedName("landingList") val landingList: List<LandingEntity>? = null,
)

data class LandingEntity(
    @SerializedName("title") val title: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("items") val items: List<LandingItemEntity>? = null,
)

data class LandingItemEntity(
    @SerializedName("title") val title: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("artist") val artist: String? = null,
)