package com.example.nopyjf.models.response

import com.example.nopyjf.models.error.ApiErrorException
import com.example.nopyjf.models.error.MysteryErrorException
import com.example.nopyjf.models.error.ServerErrorException

fun <T, R> ResponseEntity<T>.getResponseModel(doOnSuccess: () -> R): R {
    return when (status?.code) {
        StatusCode.SUCCESS -> {
            doOnSuccess()
        }
        StatusCode.API_ERROR -> {
            throw ApiErrorException(message = status.message.orEmpty())
        }
        StatusCode.SERVER_ERROR -> {
            throw ServerErrorException(message = status.message.orEmpty())
        }
        else -> {
            throw MysteryErrorException()
        }
    }
}