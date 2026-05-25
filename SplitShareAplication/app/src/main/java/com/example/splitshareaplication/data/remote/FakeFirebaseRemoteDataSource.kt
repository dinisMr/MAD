package com.example.splitshareaplication.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.splitshareaplication.data.remote.dto.ExpenseDto
import com.example.splitshareaplication.data.remote.dto.GroupDto
import com.example.splitshareaplication.data.remote.dto.SettlementDto
import com.example.splitshareaplication.data.remote.dto.UserDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeFirebaseRemoteDataSource @Inject constructor() : FirebaseRemoteDataSource {
    private val user = MutableStateFlow(UserDto("u1", "Demo User", "demo@splitshare.com"))
    private val groups = MutableStateFlow<List<GroupDto>>(
        listOf(
            GroupDto(
                id = "g1",
                name = "Barcelona Trip",
                description = "Shared travel expenses",
                createdByUserId = "u1",
                defaultCurrency = "EUR",
                createdAtEpoch = System.currentTimeMillis()
            )
        )
    )
    private val expenses = MutableStateFlow<List<ExpenseDto>>(
        listOf(
            ExpenseDto("e1", "g1", "Dinner", 48.0, "EUR", "Food", "u1", System.currentTimeMillis(), listOf("u1", "u2")),
            ExpenseDto("e2", "g1", "Train tickets", 32.0, "EUR", "Transport", "u2", System.currentTimeMillis(), listOf("u1", "u2"))
        )
    )
    private val settlements = MutableStateFlow<List<SettlementDto>>(emptyList())

    override suspend fun signIn(email: String, password: String): UserDto = user.value
    override suspend fun signUp(name: String, email: String, password: String): UserDto = UserDto("u1", name, email)
    override suspend fun signOut() = Unit

    override fun observeGroups(userId: String): Flow<List<GroupDto>> = groups
    override suspend fun createGroup(group: GroupDto) { groups.value = groups.value + group }
    override suspend fun updateGroup(group: GroupDto) { groups.value = groups.value.map { if (it.id == group.id) group else it } }
    override suspend fun deleteGroup(groupId: String) { groups.value = groups.value.filterNot { it.id == groupId } }

    override fun observeExpenses(groupId: String): Flow<List<ExpenseDto>> = expenses
    override suspend fun addExpense(expense: ExpenseDto) { expenses.value = expenses.value + expense }
    override suspend fun updateExpense(expense: ExpenseDto) { expenses.value = expenses.value.map { if (it.id == expense.id) expense else it } }
    override suspend fun deleteExpense(expenseId: String) { expenses.value = expenses.value.filterNot { it.id == expenseId } }

    override fun observeSettlements(groupId: String): Flow<List<SettlementDto>> = settlements
    override suspend fun addSettlement(settlement: SettlementDto) { settlements.value = settlements.value + settlement }
    override suspend fun saveFcmToken(userId: String, token: String) = Unit
}
