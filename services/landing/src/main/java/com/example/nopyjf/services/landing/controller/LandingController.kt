package com.example.nopyjf.services.landing.controller

import com.example.nopyjf.models.error.ErrorException
import com.example.nopyjf.models.landing.LandingDisplay
import com.example.nopyjf.services.landing.usecases.GetLandingUseCase
import javax.inject.Inject

class LandingController @Inject constructor(
    private val getLandingUseCase: GetLandingUseCase
) {
    @Throws(ErrorException::class)
    suspend fun getLanding(): List<LandingDisplay> {
        return getLandingUseCase()
    }
}