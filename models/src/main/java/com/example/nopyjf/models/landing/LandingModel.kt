package com.example.nopyjf.models.landing

data class LandingModel(
    val title: String? = "",
    val image: String? = "",
)

fun List<LandingEntity>?.transformModel(): List<LandingModel>? {
    return this?.map {
        LandingModel(
            title = it.title,
            image = it.image,
        )
    }
}

