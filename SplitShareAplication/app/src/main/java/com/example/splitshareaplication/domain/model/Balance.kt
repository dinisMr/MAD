package com.example.splitshareaplication.domain.model

data class Balance(
    val fromUserId: String,
    val toUserId: String,
    val amount: Double,
    val currency: String
)
