package com.d121211060.Bola.data

import com.d121211060.Bola.data.repository.BolaRepository
import com.d121211060.Bola.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bolaRepository: BolaRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://apiv2.allsportsapi.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val bolaRepository: BolaRepository
        get() = BolaRepository(retrofitService)
}