package com.example.splitshareaplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.data.local.entity.CurrencyRateEntity
import com.example.splitshareaplication.data.local.entity.ExpenseEntity
import com.example.splitshareaplication.data.local.entity.ExpenseSplitEntity
import com.example.splitshareaplication.data.local.entity.GroupEntity
import com.example.splitshareaplication.data.local.entity.GroupMemberEntity
import com.example.splitshareaplication.data.local.entity.SettlementEntity

@Dao
interface GroupDao {
    @Query("SELECT * FROM groups ORDER BY createdAtEpoch DESC")
    fun observeGroups(): Flow<List<GroupEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroups(groups: List<GroupEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: GroupEntity)

    @Query("DELETE FROM groups WHERE id = :groupId")
    suspend fun deleteGroup(groupId: String)
}

@Dao
interface GroupMemberDao {
    @Query("SELECT * FROM group_members WHERE groupId = :groupId")
    fun observeMembers(groupId: String): Flow<List<GroupMemberEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMembers(members: List<GroupMemberEntity>)
}

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses WHERE groupId = :groupId ORDER BY dateEpoch DESC")
    fun observeExpenses(groupId: String): Flow<List<ExpenseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: ExpenseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpenses(expenses: List<ExpenseEntity>)

    @Query("DELETE FROM expenses WHERE id = :expenseId")
    suspend fun deleteExpense(expenseId: String)
}

@Dao
interface ExpenseSplitDao {
    @Query("SELECT * FROM expense_splits WHERE expenseId = :expenseId")
    fun observeSplits(expenseId: String): Flow<List<ExpenseSplitEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSplits(splits: List<ExpenseSplitEntity>)
}

@Dao
interface SettlementDao {
    @Query("SELECT * FROM settlements WHERE groupId = :groupId ORDER BY dateEpoch DESC")
    fun observeSettlements(groupId: String): Flow<List<SettlementEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettlement(settlement: SettlementEntity)
}

@Dao
interface CurrencyRateDao {
    @Query("SELECT * FROM currency_rates WHERE baseCurrency = :base AND targetCurrency = :target")
    suspend fun getRate(base: String, target: String): CurrencyRateEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRate(rate: CurrencyRateEntity)
}
