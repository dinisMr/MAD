package com.example.splitshareaplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.splitshareaplication.domain.model.Balance
import com.example.splitshareaplication.domain.model.Expense
import com.example.splitshareaplication.domain.model.Group

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.uiState.collectAsState()

    if (state.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(12.dp))
            Text("Loading Split Share...")
        }
        return
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "SplitShareAplication",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Project 3 Android skeleton",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        item {
            Button(onClick = viewModel::addDemoExpense) {
                Text("Add demo expense")
            }
        }

        item {
            SectionTitle("Groups")
        }

        items(state.groups) { group ->
            GroupCard(group)
        }

        item {
            SectionTitle("Expenses")
        }

        items(state.expenses) { expense ->
            ExpenseCard(expense)
        }

        item {
            SectionTitle("Balances")
        }

        items(state.balances) { balance ->
            BalanceCard(balance)
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = 8.dp)
    )
}

@Composable
private fun GroupCard(group: Group) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(group.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(group.description ?: "No description")
            Text("Default currency: ${group.defaultCurrency}")
        }
    }
}

@Composable
private fun ExpenseCard(expense: Expense) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(expense.title, fontWeight = FontWeight.Bold)
                Text(expense.category)
            }
            Text("${expense.amount} ${expense.currency}", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun BalanceCard(balance: Balance) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Debt", fontWeight = FontWeight.Bold)
            Text("${balance.fromUserId} owes ${balance.toUserId}")
            Text("${balance.amount} ${balance.currency}")
        }
    }
}
