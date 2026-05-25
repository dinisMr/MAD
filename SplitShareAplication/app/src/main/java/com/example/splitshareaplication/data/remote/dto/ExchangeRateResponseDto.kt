package com.example.splitshareaplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ExchangeRateResponseDto(
    @SerializedName("result") val result: String,
    @SerializedName("base_code") val baseCode: String,
    @SerializedName("time_last_update_unix") val lastUpdateEpoch: Long,
    @SerializedName("conversion_rates") val conversionRates: Map<String, Double>
)
