package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Card(
    val away_fault: String,
    val away_player_id: String,
    val card: String,
    val home_fault: String,
    val home_player_id: String,
    val info: String,
    val info_time: String,
    val time: String
): Parcelable