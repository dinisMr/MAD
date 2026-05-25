package com.example.splitshareaplication.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.splitshareaplication.domain.model.Group

interface GroupRepository {
    fun observeGroups(userId: String): Flow<List<Group>>
    suspend fun createGroup(group: Group): Result<Unit>
    suspend fun updateGroup(group: Group): Result<Unit>
    suspend fun deleteGroup(groupId: String): Result<Unit>
}
