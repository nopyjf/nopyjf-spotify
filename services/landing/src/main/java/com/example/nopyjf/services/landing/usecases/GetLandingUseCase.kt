package com.example.nopyjf.services.landing.usecases

import com.example.nopyjf.models.error.ErrorException
import com.example.nopyjf.models.landing.LandingDisplay
import com.example.nopyjf.models.landing.transformDisplay
import com.example.nopyjf.services.landing.repository.LandingRepository
import javax.inject.Inject

class GetLandingUseCase @Inject constructor(
    private val repository: LandingRepository,
) {
    @Throws(ErrorException::class)
    suspend operator fun invoke(): List<LandingDisplay> {
        return repository.getLanding().transformDisplay()
    }
}