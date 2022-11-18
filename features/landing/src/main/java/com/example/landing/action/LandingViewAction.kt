package com.example.landing.action

import com.example.nopyjf.models.error.ErrorException
import com.example.nopyjf.models.response.StatusCode
import kotlinx.coroutines.flow.MutableStateFlow

sealed class LandingViewAction {
    object Success : LandingViewAction()
    object Loading : LandingViewAction()
    object ApiError : LandingViewAction()
    object ServerError : LandingViewAction()
    object MysteryError : LandingViewAction()

    companion object {
        fun getLandingViewAction(
            state: MutableStateFlow<LandingViewAction>,
            e: ErrorException,
        ) {
            when (e.code) {
                StatusCode.API_ERROR -> {
                    state.value = ApiError
                }
                StatusCode.SERVER_ERROR -> {
                    state.value = ServerError
                }
                else -> {
                    state.value = MysteryError
                }
            }
        }
    }
}