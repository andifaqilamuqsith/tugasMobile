package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class AwayScorer(
    val `in`: String,
    val in_id: Long,
    val `out`: String,
    val out_id: Int
): Parcelable