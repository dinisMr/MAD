package com.example.splitshareaplication.data.remote.dto

data class UserDto(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val fcmToken: String? = null
)

data class GroupDto(
    val id: String = "",
    val name: String = "",
    val description: String? = null,
    val createdByUserId: String = "",
    val defaultCurrency: String = "EUR",
    val createdAtEpoch: Long = 0L,
    val memberIds: List<String> = emptyList()
)

data class ExpenseDto(
    val id: String = "",
    val groupId: String = "",
    val title: String = "",
    val amount: Double = 0.0,
    val currency: String = "EUR",
    val category: String = "Other",
    val paidByUserId: String = "",
    val dateEpoch: Long = 0L,
    val participantIds: List<String> = emptyList(),
    val note: String? = null
)

data class ExpenseSplitDto(
    val expenseId: String = "",
    val userId: String = "",
    val shareAmount: Double = 0.0,
    val isPaid: Boolean = false
)

data class SettlementDto(
    val id: String = "",
    val groupId: String = "",
    val fromUserId: String = "",
    val toUserId: String = "",
    val amount: Double = 0.0,
    val currency: String = "EUR",
    val dateEpoch: Long = 0L
)
