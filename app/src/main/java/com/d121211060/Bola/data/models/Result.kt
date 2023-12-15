package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Result(
    val away_team_key: Int?,
    val away_team_logo: String?,
    val cards: List<Card>?,
    val country_logo: String?,
    val country_name: String?,
    val event_away_formation: String?,
    val event_away_team: String?,
    val event_country_key: Int?,
    val event_date: String?,
    val event_final_result: String?,
    val event_ft_result: String?,
    val event_halftime_result: String?,
    val event_home_formation: String?,
    val event_home_team: String?,
    val event_key: Int?,
    val event_live: String?,
    val event_penalty_result: String?,
    val event_referee: String?,
    val event_stadium: String?,
    val event_status: String?,
    val event_time: String?,
    val fk_stage_key: Int?,
    val goalscorers: List<Goalscorer>?,
    val home_team_key: Int?,
    val home_team_logo: String?,
//    val league_group: Any?,
    val league_key: Int?,
    val league_logo: String?,
    val league_name: String?,
    val league_round: String?,
    val league_season: String?,
    val lineups: Lineups?,
    val stage_name: String?,
    val statistics: List<Statistic>?,
//    val substitutes: List<SubstituteXX>?,
    val vars: Vars
): Parcelable