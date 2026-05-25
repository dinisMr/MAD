package com.example.splitshareaplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.splitshareaplication.data.local.dao.CurrencyRateDao
import com.example.splitshareaplication.data.local.dao.ExpenseDao
import com.example.splitshareaplication.data.local.dao.ExpenseSplitDao
import com.example.splitshareaplication.data.local.dao.GroupDao
import com.example.splitshareaplication.data.local.dao.GroupMemberDao
import com.example.splitshareaplication.data.local.dao.SettlementDao
import com.example.splitshareaplication.data.local.entity.CurrencyRateEntity
import com.example.splitshareaplication.data.local.entity.ExpenseEntity
import com.example.splitshareaplication.data.local.entity.ExpenseSplitEntity
import com.example.splitshareaplication.data.local.entity.GroupEntity
import com.example.splitshareaplication.data.local.entity.GroupMemberEntity
import com.example.splitshareaplication.data.local.entity.SettlementEntity
import com.example.splitshareaplication.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        GroupEntity::class,
        GroupMemberEntity::class,
        ExpenseEntity::class,
        ExpenseSplitEntity::class,
        SettlementEntity::class,
        CurrencyRateEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groupDao(): GroupDao
    abstract fun groupMemberDao(): GroupMemberDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun expenseSplitDao(): ExpenseSplitDao
    abstract fun settlementDao(): SettlementDao
    abstract fun currencyRateDao(): CurrencyRateDao
}
