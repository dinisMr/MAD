package com.example.splitshareaplication.domain.model

data class Settlement(
    val id: String,
    val groupId: String,
    val fromUserId: String,
    val toUserId: String,
    val amount: Double,
    val currency: String,
    val dateEpoch: Long
)
