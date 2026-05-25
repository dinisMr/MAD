package com.example.splitshareaplication.domain.model

data class Expense(
    val id: String,
    val groupId: String,
    val title: String,
    val amount: Double,
    val currency: String,
    val category: String,
    val paidByUserId: String,
    val dateEpoch: Long,
    val participants: List<ExpenseSplit>,
    val note: String?
)
