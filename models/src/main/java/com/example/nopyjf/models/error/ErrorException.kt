package com.example.nopyjf.models.error

import com.example.nopyjf.models.response.StatusCode

sealed class ErrorException(
    override val message: String? = null,
    val code: String? = null,
    val throwable: Throwable? = null,
) : Exception(message) {

    class ApiErrorException(message: String) :
        ErrorException(code = StatusCode.API_ERROR, message = message)

    class ServerErrorException(message: String) :
        ErrorException(code = StatusCode.SERVER_ERROR, message = message)

    class MysteryErrorException(message: String? = null, throwable: Throwable? = null) :
        ErrorException(code = StatusCode.MYSTERY_ERROR, message = message, throwable = throwable)
}