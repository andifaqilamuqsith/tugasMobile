package com.d121211060.Bola.data.repository

import com.d121211060.Bola.data.response.GetMatchesResponse
import com.d121211060.Bola.data.source.remote.ApiService

class BolaRepository(private val apiService: ApiService) {

    suspend fun getBola(): GetMatchesResponse {
        return apiService.getMatches()
    }
}