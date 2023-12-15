package com.d121211060.Bola.data.source.remote

import com.d121211060.Bola.data.response.GetMatchesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //&from=&to=
    @GET("football")
    suspend fun getMatches(
        @Query("met") met: String = "Fixtures",
        @Query("APIkey") APIkey: String = "5c539b8b041c0693f03a927b9b2d8e1bcb9557bd537772cbb67247ecf7841fdf",
        @Query("from") from: String = "2021-05-18",
        @Query("to") to: String = "2021-05-18",
    ) : GetMatchesResponse
}