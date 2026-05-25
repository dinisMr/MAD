package com.example.splitshareaplication.data.remote

import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.data.remote.dto.ExpenseDto
import com.example.splitshareaplication.data.remote.dto.GroupDto
import com.example.splitshareaplication.data.remote.dto.SettlementDto
import com.example.splitshareaplication.data.remote.dto.UserDto

interface FirebaseRemoteDataSource {
    suspend fun signIn(email: String, password: String): UserDto
    suspend fun signUp(name: String, email: String, password: String): UserDto
    suspend fun signOut()
    fun observeGroups(userId: String): Flow<List<GroupDto>>
    suspend fun createGroup(group: GroupDto)
    suspend fun updateGroup(group: GroupDto)
    suspend fun deleteGroup(groupId: String)
    fun observeExpenses(groupId: String): Flow<List<ExpenseDto>>
    suspend fun addExpense(expense: ExpenseDto)
    suspend fun updateExpense(expense: ExpenseDto)
    suspend fun deleteExpense(expenseId: String)
    fun observeSettlements(groupId: String): Flow<List<SettlementDto>>
    suspend fun addSettlement(settlement: SettlementDto)
    suspend fun saveFcmToken(userId: String, token: String)
}
