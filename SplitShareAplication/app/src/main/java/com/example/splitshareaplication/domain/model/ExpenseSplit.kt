package com.example.splitshareaplication.domain.model

data class ExpenseSplit(
    val userId: String,
    val shareAmount: Double,
    val isPaid: Boolean
)
