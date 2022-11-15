package com.example.nopyjf.models.error

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorDisplay(
    val message: String = "",
) : Parcelable

