package com.example.splitshareaplication.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.domain.model.Expense

interface ExpenseRepository {
    fun observeExpenses(groupId: String): Flow<List<Expense>>
    suspend fun addExpense(expense: Expense): Result<Unit>
    suspend fun updateExpense(expense: Expense): Result<Unit>
    suspend fun deleteExpense(expenseId: String): Result<Unit>
}
