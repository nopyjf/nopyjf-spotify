package com.example.nopyjf.services.landing.controller

import com.example.nopyjf.models.landing.LandingDisplay
import com.example.nopyjf.services.landing.usecases.GetLandingUseCase

class LandingController(
    private val getLandingUseCase: GetLandingUseCase
) {
    suspend fun getLanding(): LandingDisplay {
        return getLandingUseCase()
    }
}