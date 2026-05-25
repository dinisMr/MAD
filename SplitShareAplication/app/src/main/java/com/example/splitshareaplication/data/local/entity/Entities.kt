package com.example.splitshareaplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String
)

@Entity(tableName = "groups")
data class GroupEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String?,
    val createdByUserId: String,
    val defaultCurrency: String,
    val createdAtEpoch: Long
)

@Entity(tableName = "group_members", primaryKeys = ["groupId", "userId"])
data class GroupMemberEntity(
    val groupId: String,
    val userId: String,
    val role: String
)

@Entity(tableName = "expenses")
data class ExpenseEntity(
    @PrimaryKey val id: String,
    val groupId: String,
    val title: String,
    val amount: Double,
    val currency: String,
    val category: String,
    val paidByUserId: String,
    val dateEpoch: Long,
    val note: String?
)

@Entity(tableName = "expense_splits", primaryKeys = ["expenseId", "userId"])
data class ExpenseSplitEntity(
    val expenseId: String,
    val userId: String,
    val shareAmount: Double,
    val isPaid: Boolean
)

@Entity(tableName = "settlements")
data class SettlementEntity(
    @PrimaryKey val id: String,
    val groupId: String,
    val fromUserId: String,
    val toUserId: String,
    val amount: Double,
    val currency: String,
    val dateEpoch: Long
)

@Entity(tableName = "currency_rates", primaryKeys = ["baseCurrency", "targetCurrency"])
data class CurrencyRateEntity(
    val baseCurrency: String,
    val targetCurrency: String,
    val rate: Double,
    val fetchedAtEpoch: Long
)
