package com.example.nopyjf.models.response

sealed class ResponseModel<T>(
    val message: String = "",
    val data: T? = null
) {
    class Success<T>(data: T?) : ResponseModel<T>(data = data)
    class ApiError<T>(message: String) : ResponseModel<T>(message = message)
    class ServerError<T>(message: String) : ResponseModel<T>(message = message)
    class MysteryError<T> : ResponseModel<T>()
}

fun <T, R> ResponseEntity<T>.getResponseModel(doOnSuccess: () -> ResponseModel<R>): ResponseModel<R> {
    return when (status?.code) {
        StatusCode.SUCCESS -> {
            doOnSuccess()
        }
        StatusCode.API_ERROR -> {
            ResponseModel.ApiError(status.message.orEmpty())
        }
        StatusCode.SERVER_ERROR -> {
            ResponseModel.ServerError(status.message.orEmpty())
        }
        else -> {
            ResponseModel.MysteryError()
        }
    }
}