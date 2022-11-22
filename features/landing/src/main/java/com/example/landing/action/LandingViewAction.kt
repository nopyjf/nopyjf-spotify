package com.example.landing.action

import com.example.nopyjf.models.error.ErrorDisplay
import com.example.nopyjf.models.landing.LandingListDisplay

sealed class LandingViewAction {
    class Success(val display: LandingListDisplay) : LandingViewAction()
    object Loading : LandingViewAction()
    class ShowErrorDialog(val errorDisplay: ErrorDisplay) : LandingViewAction()
}