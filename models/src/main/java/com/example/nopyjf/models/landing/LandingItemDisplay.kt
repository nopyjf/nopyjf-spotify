package com.example.nopyjf.models.landing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LandingListDisplay(
    val landingList: List<LandingDisplay> = listOf(),
) : Parcelable

@Parcelize
data class LandingDisplay(
    val title: String = "",
    val type: String = "",
    val items: List<LandingItemDisplay> = listOf(),
) : Parcelable

@Parcelize
data class LandingItemDisplay(
    val title: String = "",
    val image: String = "",
    val type: String = "",
    val artist: String = "",
) : Parcelable

enum class LandingType {
    RECOMMEND,
    PLAYLIST
}

fun LandingListModel?.transformModel(): LandingListDisplay {
    return LandingListDisplay(
        landingList = this?.landingList?.map { landing ->
            LandingDisplay(
                title = landing.title.orEmpty(),
                type = landing.type.orEmpty(),
                items = landing.items?.map { item ->
                    LandingItemDisplay(
                        title = item.title.orEmpty(),
                        image = item.image.orEmpty(),
                        type = item.type.orEmpty(),
                        artist = item.artist.orEmpty(),
                    )
                } ?: listOf()
            )
        } ?: listOf()
    )
}

