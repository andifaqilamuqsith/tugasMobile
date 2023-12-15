package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SubstituteXX(
    val away_assist: String,
    val away_scorer: AwayScorer,
    val home_assist: String,
    val home_scorer: HomeScorer,
    val info: String,
    val info_time: String,
    val score: String,
    val time: String
): Parcelable