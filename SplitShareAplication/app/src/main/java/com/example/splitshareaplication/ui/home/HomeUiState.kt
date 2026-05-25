package com.example.splitshareaplication.ui.home

import com.example.splitshareaplication.domain.model.Balance
import com.example.splitshareaplication.domain.model.Expense
import com.example.splitshareaplication.domain.model.Group

data class HomeUiState(
    val isLoading: Boolean = false,
    val groups: List<Group> = emptyList(),
    val selectedGroupId: String = "g1",
    val expenses: List<Expense> = emptyList(),
    val balances: List<Balance> = emptyList(),
    val errorMessage: String? = null
)
