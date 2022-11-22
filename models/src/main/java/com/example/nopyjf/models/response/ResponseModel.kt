package com.example.nopyjf.models.response

import com.example.nopyjf.models.error.ErrorException

fun <T> ResponseEntity<T>.getErrorException(): ErrorException? {
    return when (status?.code) {
        StatusCode.API_ERROR -> {
            ErrorException.ApiErrorException(message = status.message.orEmpty())
        }
        StatusCode.SERVER_ERROR -> {
            ErrorException.ServerErrorException(message = status.message.orEmpty())
        }
        else -> {
            null
        }
    }
}