package com.example.landing.action

sealed class LandingViewAction {
    object Success: LandingViewAction()
    object ShowLoading : LandingViewAction()
    object ShowError: LandingViewAction()
}