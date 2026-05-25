package com.example.splitshareaplication.domain.repository

interface NotificationRepository {
    suspend fun updateDeviceToken(userId: String, token: String): Result<Unit>
    suspend fun notifyExpenseAdded(groupId: String, expenseId: String): Result<Unit>
    suspend fun notifySettlementAdded(groupId: String, settlementId: String): Result<Unit>
}
