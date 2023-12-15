package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class HomeTeam(
    val coaches: List<Coache>,
//    val missing_players: List<Any>,
    val starting_lineups: List<StartingLineup>,
    val substitutes: List<SubstituteXX>
): Parcelable