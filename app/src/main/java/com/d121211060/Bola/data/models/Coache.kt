package com.d121211060.Bola.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Coache(
    val coache: String,
//    val coache_country: Any
): Parcelable