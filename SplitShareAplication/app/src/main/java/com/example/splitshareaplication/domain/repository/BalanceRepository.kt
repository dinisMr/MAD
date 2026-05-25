package com.example.splitshareaplication.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.domain.model.Balance

interface BalanceRepository {
    fun observeBalances(groupId: String): Flow<List<Balance>>
    suspend fun calculateBalances(groupId: String): Result<List<Balance>>
}
