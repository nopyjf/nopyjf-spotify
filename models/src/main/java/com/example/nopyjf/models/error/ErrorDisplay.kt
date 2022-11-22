package com.example.nopyjf.models.error

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.SocketTimeoutException

@Parcelize
data class ErrorDisplay(
    val throwable: Throwable,
    val title: String = "",
    val description: String = "",
    val okButton: ButtonDisplay? = null,
    val cancelButton: ButtonDisplay? = null,
) : Parcelable

@Parcelize
data class ButtonDisplay(
    val title: String,
    val action: ButtonActionType,
) : Parcelable

enum class ButtonActionType {
    CLOSE,
    EXIT_SCREEN,
}

fun Throwable.transformError(): ErrorDisplay {
    return when (this) {
        is SocketTimeoutException -> {
            ErrorDisplay(
                throwable = this,
                title = "อ้าวววว",
                description = "เน็ตแตกพ่าย ลองใหม่อีกทีนะ",
                okButton = ButtonDisplay("ตกลง", ButtonActionType.EXIT_SCREEN)
            )
        }
        else -> {
            ErrorDisplay(
                throwable = this,
                title = "อ้าวววว",
                description = "ระบบแตกพ่าย ลองใหม่อีกทีนะ",
                okButton = ButtonDisplay("ตกลง", ButtonActionType.EXIT_SCREEN)
            )
        }
    }
}

