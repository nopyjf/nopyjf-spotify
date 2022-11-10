package com.example.nopyjf.models.landing

import com.example.nopyjf.models.response.ResponseModel

data class LandingModel(
    val title: String? = "",
    val image: String? = "",
)

fun LandingEntity?.transformModel(): ResponseModel<LandingModel> {
    return ResponseModel.Success(
        LandingModel(
            title = this?.title,
            image = this?.image
        )
    )
}

