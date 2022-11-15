package com.example.nopyjf.models.error

import com.example.nopyjf.models.response.StatusCode

open class ErrorException(
    code: String? = "",
    message: String = "",
) : Exception(message)

class ApiErrorException(
    code: String = StatusCode.API_ERROR,
    message: String = "",
) : ErrorException(code = code, message = message)

class ServerErrorException(
    code: String = StatusCode.SERVER_ERROR,
    message: String = "",
) : ErrorException(code = code, message = message)

class MysteryErrorException(
    code: String = StatusCode.MYSTERY_ERROR,
    message: String = "",
) : ErrorException(code = code, message = message)