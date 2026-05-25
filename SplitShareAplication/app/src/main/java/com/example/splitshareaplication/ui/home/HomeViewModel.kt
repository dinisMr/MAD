package com.example.splitshareaplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import com.example.splitshareaplication.domain.model.Expense
import com.example.splitshareaplication.domain.model.ExpenseSplit
import com.example.splitshareaplication.domain.repository.BalanceRepository
import com.example.splitshareaplication.domain.repository.ExpenseRepository
import com.example.splitshareaplication.domain.repository.GroupRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val groupRepository: GroupRepository,
    private val expenseRepository: ExpenseRepository,
    private val balanceRepository: BalanceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadDemoData()
    }

    private fun loadDemoData() {
        viewModelScope.launch {
            combine(
                groupRepository.observeGroups("u1"),
                expenseRepository.observeExpenses("g1"),
                balanceRepository.observeBalances("g1")
            ) { groups, expenses, balances ->
                HomeUiState(
                    isLoading = false,
                    groups = groups,
                    selectedGroupId = "g1",
                    expenses = expenses,
                    balances = balances
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }

    fun addDemoExpense() {
        viewModelScope.launch {
            val newExpense = Expense(
                id = "e" + System.currentTimeMillis(),
                groupId = "g1",
                title = "Coffee",
                amount = 12.0,
                currency = "EUR",
                category = "Food",
                paidByUserId = "u1",
                dateEpoch = System.currentTimeMillis(),
                participants = listOf(
                    ExpenseSplit("u1", 6.0, true),
                    ExpenseSplit("u2", 6.0, false)
                ),
                note = "Demo expense added from UI"
            )
            expenseRepository.addExpense(newExpense)
        }
    }
}
