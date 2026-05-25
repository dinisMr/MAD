package com.example.splitshareaplication.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.domain.model.AppUser

interface AuthRepository {
    val currentUser: Flow<AppUser?>
    suspend fun signIn(email: String, password: String): Result<AppUser>
    suspend fun signUp(name: String, email: String, password: String): Result<AppUser>
    suspend fun signOut()
}
