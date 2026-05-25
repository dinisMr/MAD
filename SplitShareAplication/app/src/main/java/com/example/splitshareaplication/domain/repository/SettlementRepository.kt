package com.example.splitshareaplication.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.domain.model.Settlement

interface SettlementRepository {
    fun observeSettlements(groupId: String): Flow<List<Settlement>>
    suspend fun addSettlement(settlement: Settlement): Result<Unit>
}
