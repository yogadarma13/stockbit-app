package com.yogadarma.core.data.source.remote.network

import com.yogadarma.core.data.source.remote.response.ListCryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("totaltoptiervolfull")
    suspend fun getAllCrypto(
        @Query("limit") limit: Int,
        @Query("tsym") tsym: String
    ): ListCryptoResponse
}