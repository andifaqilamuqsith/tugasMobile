package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Lineups(
    val away_team: AwayTeam,
    val home_team: HomeTeam
): Parcelable