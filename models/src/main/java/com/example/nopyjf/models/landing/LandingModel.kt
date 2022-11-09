package com.example.nopyjf.models.landing

data class LandingModel(
    val title: String? = "",
    val image: String? = "",
)

fun LandingEntity.transformModel(): LandingModel {
    return LandingModel(
        title,
        image,
    )
}

