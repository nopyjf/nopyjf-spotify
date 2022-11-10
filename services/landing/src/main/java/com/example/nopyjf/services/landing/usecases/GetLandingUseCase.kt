package com.example.nopyjf.services.landing.usecases

import android.os.Parcelable
import com.example.nopyjf.models.landing.transformDisplay
import com.example.nopyjf.models.response.ResponseModel
import com.example.nopyjf.services.landing.repository.LandingRepository

class GetLandingUseCase(
    private val repository: LandingRepository,
) {
    suspend operator fun invoke(): Parcelable? {
        return when (val response = repository.getLanding()) {
            is ResponseModel.Success -> {
                return response.data?.transformDisplay()
            }
            else -> {
                return response.message?.orEmpty()
            }
        }
    }
}