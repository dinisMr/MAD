package com.example.splitshareaplication.domain.model

data class CurrencyRate(
    val baseCurrency: String,
    val targetCurrency: String,
    val rate: Double,
    val fetchedAtEpoch: Long
)
