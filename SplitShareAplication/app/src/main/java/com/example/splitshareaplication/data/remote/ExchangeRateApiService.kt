package com.example.splitshareaplication.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.splitshareaplication.data.remote.dto.ExchangeRateResponseDto

interface ExchangeRateApiService {
    @GET("v6/{apiKey}/latest/{baseCurrency}")
    suspend fun getLatestRates(
        @Path("apiKey") apiKey: String,
        @Path("baseCurrency") baseCurrency: String
    ): Response<ExchangeRateResponseDto>
}
