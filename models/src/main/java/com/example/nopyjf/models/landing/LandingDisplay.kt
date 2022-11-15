package com.example.nopyjf.models.landing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LandingDisplay(
    val title: String = "",
    val image: String = "",
) : Parcelable

fun List<LandingModel>?.transformDisplay(): List<LandingDisplay> {
    return this?.map {
        LandingDisplay(
            it.title.orEmpty(),
            it.image.orEmpty(),
        )
    } ?: listOf()


}

