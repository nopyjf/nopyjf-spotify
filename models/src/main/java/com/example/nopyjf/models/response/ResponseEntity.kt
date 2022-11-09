package com.example.nopyjf.models.response

import com.google.gson.annotations.SerializedName

open class ResponseEntity<T> {
    @SerializedName("status")
    val status: StatusEntity? = null

    @SerializedName("data")
    val data: T? = null
}

open class StatusEntity {
    @SerializedName("code")
    val code: String? = null

    @SerializedName("message")
    val message: String? = null
}