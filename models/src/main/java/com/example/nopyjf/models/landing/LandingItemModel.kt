package com.example.nopyjf.models.landing

data class LandingListModel(
    val landingList: List<LandingModel>? = listOf(),
)

data class LandingModel(
    val title: String? = "",
    val type: String? = "",
    val items: List<LandingItemModel>? = listOf(),
)

data class LandingItemModel(
    val title: String? = "",
    val image: String? = "",
    val type: String? = "",
    val artist: String? = "",
)

fun LandingListEntity?.transformModel(): LandingListModel {
    return LandingListModel(
        landingList = this?.landingList?.map { landing ->
            LandingModel(
                title = landing.title,
                type = landing.type,
                items = landing.items?.map { item ->
                    LandingItemModel(
                        title = item.title,
                        image = item.image,
                        type = item.type,
                        artist = item.artist,
                    )
                }
            )
        }
    )
}

