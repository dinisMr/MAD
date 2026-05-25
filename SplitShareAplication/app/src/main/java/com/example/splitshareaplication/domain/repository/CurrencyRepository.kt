package com.example.splitshareaplication.domain.repository

interface CurrencyRepository {
    suspend fun convert(amount: Double, fromCurrency: String, toCurrency: String): Result<Double>
}
