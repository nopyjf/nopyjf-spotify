package com.example.nopyjf.models.landing

data class LandingDisplay(
    private val title: String = "",
    private val image: String = "",
)

fun LandingModel?.transformDisplay(): LandingDisplay {
    return LandingDisplay(
        this?.title.orEmpty(),
        this?.image.orEmpty(),
    )
}

