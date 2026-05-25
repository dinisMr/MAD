package com.example.splitshareaplication.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import com.example.splitshareaplication.data.mapper.toDomain
import com.example.splitshareaplication.data.mapper.toDto
import com.example.splitshareaplication.data.remote.FirebaseRemoteDataSource
import com.example.splitshareaplication.domain.model.AppUser
import com.example.splitshareaplication.domain.model.Balance
import com.example.splitshareaplication.domain.model.Expense
import com.example.splitshareaplication.domain.model.Group
import com.example.splitshareaplication.domain.model.Settlement
import com.example.splitshareaplication.domain.repository.AuthRepository
import com.example.splitshareaplication.domain.repository.BalanceRepository
import com.example.splitshareaplication.domain.repository.CurrencyRepository
import com.example.splitshareaplication.domain.repository.ExpenseRepository
import com.example.splitshareaplication.domain.repository.GroupRepository
import com.example.splitshareaplication.domain.repository.NotificationRepository
import com.example.splitshareaplication.domain.repository.SettlementRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val remote: FirebaseRemoteDataSource
) : AuthRepository {
    private val _currentUser = MutableStateFlow<AppUser?>(AppUser("u1", "Demo User", "demo@splitshare.com"))
    override val currentUser: Flow<AppUser?> = _currentUser

    override suspend fun signIn(email: String, password: String): Result<AppUser> =
        runCatching { remote.signIn(email, password).toDomain().also { _currentUser.value = it } }

    override suspend fun signUp(name: String, email: String, password: String): Result<AppUser> =
        runCatching { remote.signUp(name, email, password).toDomain().also { _currentUser.value = it } }

    override suspend fun signOut() {
        remote.signOut()
        _currentUser.value = null
    }
}

@Singleton
class GroupRepositoryImpl @Inject constructor(
    private val remote: FirebaseRemoteDataSource
) : GroupRepository {
    override fun observeGroups(userId: String): Flow<List<Group>> =
        remote.observeGroups(userId).map { list -> list.map { it.toDomain() } }

    override suspend fun createGroup(group: Group): Result<Unit> =
        runCatching { remote.createGroup(group.toDto()) }

    override suspend fun updateGroup(group: Group): Result<Unit> =
        runCatching { remote.updateGroup(group.toDto()) }

    override suspend fun deleteGroup(groupId: String): Result<Unit> =
        runCatching { remote.deleteGroup(groupId) }
}

@Singleton
class ExpenseRepositoryImpl @Inject constructor(
    private val remote: FirebaseRemoteDataSource
) : ExpenseRepository {
    override fun observeExpenses(groupId: String): Flow<List<Expense>> =
        remote.observeExpenses(groupId).map { list -> list.map { it.toDomain() } }

    override suspend fun addExpense(expense: Expense): Result<Unit> =
        runCatching { remote.addExpense(expense.toDto()) }

    override suspend fun updateExpense(expense: Expense): Result<Unit> =
        runCatching { remote.updateExpense(expense.toDto()) }

    override suspend fun deleteExpense(expenseId: String): Result<Unit> =
        runCatching { remote.deleteExpense(expenseId) }
}

@Singleton
class SettlementRepositoryImpl @Inject constructor(
    private val remote: FirebaseRemoteDataSource
) : SettlementRepository {
    override fun observeSettlements(groupId: String): Flow<List<Settlement>> =
        remote.observeSettlements(groupId).map { list -> list.map { it.toDomain() } }

    override suspend fun addSettlement(settlement: Settlement): Result<Unit> =
        runCatching { remote.addSettlement(settlement.toDto()) }
}

@Singleton
class BalanceRepositoryImpl @Inject constructor() : BalanceRepository {
    private val balances = MutableStateFlow(
        listOf(Balance("u2", "u1", 40.0, "EUR"))
    )

    override fun observeBalances(groupId: String): Flow<List<Balance>> = balances

    override suspend fun calculateBalances(groupId: String): Result<List<Balance>> =
        Result.success(balances.value)
}

@Singleton
class CurrencyRepositoryImpl @Inject constructor() : CurrencyRepository {
    override suspend fun convert(amount: Double, fromCurrency: String, toCurrency: String): Result<Double> {
        val result = if (fromCurrency == toCurrency) amount else amount * 4.25
        return Result.success(result)
    }
}

@Singleton
class NotificationRepositoryImpl @Inject constructor() : NotificationRepository {
    override suspend fun updateDeviceToken(userId: String, token: String): Result<Unit> = Result.success(Unit)
    override suspend fun notifyExpenseAdded(groupId: String, expenseId: String): Result<Unit> = Result.success(Unit)
    override suspend fun notifySettlementAdded(groupId: String, settlementId: String): Result<Unit> = Result.success(Unit)
}
