package com.example.nopyjf.services.landing.usecases

import android.content.Context
import com.example.nopyjf.models.landing.LandingListDisplay
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.services.landing.repository.LandingRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLandingUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: LandingRepository,
) {
    suspend operator fun invoke(
        onSuccess: (LandingListDisplay) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        repository.getLanding()
            .catch { onError(it) }
            .map { it.transformModel(context) }
            .collect { onSuccess(it) }
    }
}