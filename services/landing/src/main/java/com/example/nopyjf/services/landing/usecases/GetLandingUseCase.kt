package com.example.nopyjf.services.landing.usecases

import com.example.nopyjf.models.landing.LandingDisplay
import com.example.nopyjf.models.landing.transformDisplay
import com.example.nopyjf.services.landing.repository.LandingRepository

class GetLandingUseCase(
    private val repository: LandingRepository,
) {
    suspend operator fun invoke(): LandingDisplay {
        return repository.getLanding().transformDisplay()
    }
}