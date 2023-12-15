package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Substitute(
    val info_time: String,
    val player: String,
//    val player_country: Any,
    val player_key: Long,
    val player_number: Int,
    val player_position: Int
): Parcelable