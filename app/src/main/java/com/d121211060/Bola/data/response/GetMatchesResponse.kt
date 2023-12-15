package com.d121211060.Bola.data.response

import com.d121211060.Bola.data.models.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetMatchesResponse(
    @SerialName("result")
    val result: List<Result>?,
    @SerialName("success")
    val success: Int?,
)