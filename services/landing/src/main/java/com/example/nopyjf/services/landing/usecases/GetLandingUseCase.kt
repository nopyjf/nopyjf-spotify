package com.example.nopyjf.services.landing.usecases

import com.example.nopyjf.models.error.ErrorException
import com.example.nopyjf.models.landing.LandingListDisplay
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.services.landing.repository.LandingRepository
import javax.inject.Inject

class GetLandingUseCase @Inject constructor(
    private val repository: LandingRepository,
) {
    @Throws(ErrorException::class)
    suspend operator fun invoke(): LandingListDisplay {
        return repository.getLanding().transformModel()
    }
}