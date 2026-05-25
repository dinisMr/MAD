package com.example.splitshareaplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.splitshareaplication.data.repository.AuthRepositoryImpl
import com.example.splitshareaplication.data.repository.BalanceRepositoryImpl
import com.example.splitshareaplication.data.repository.CurrencyRepositoryImpl
import com.example.splitshareaplication.data.repository.ExpenseRepositoryImpl
import com.example.splitshareaplication.data.repository.GroupRepositoryImpl
import com.example.splitshareaplication.data.repository.NotificationRepositoryImpl
import com.example.splitshareaplication.data.repository.SettlementRepositoryImpl
import com.example.splitshareaplication.domain.repository.AuthRepository
import com.example.splitshareaplication.domain.repository.BalanceRepository
import com.example.splitshareaplication.domain.repository.CurrencyRepository
import com.example.splitshareaplication.domain.repository.ExpenseRepository
import com.example.splitshareaplication.domain.repository.GroupRepository
import com.example.splitshareaplication.domain.repository.NotificationRepository
import com.example.splitshareaplication.domain.repository.SettlementRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds @Singleton abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
    @Binds @Singleton abstract fun bindGroupRepository(impl: GroupRepositoryImpl): GroupRepository
    @Binds @Singleton abstract fun bindExpenseRepository(impl: ExpenseRepositoryImpl): ExpenseRepository
    @Binds @Singleton abstract fun bindSettlementRepository(impl: SettlementRepositoryImpl): SettlementRepository
    @Binds @Singleton abstract fun bindBalanceRepository(impl: BalanceRepositoryImpl): BalanceRepository
    @Binds @Singleton abstract fun bindCurrencyRepository(impl: CurrencyRepositoryImpl): CurrencyRepository
    @Binds @Singleton abstract fun bindNotificationRepository(impl: NotificationRepositoryImpl): NotificationRepository
}
