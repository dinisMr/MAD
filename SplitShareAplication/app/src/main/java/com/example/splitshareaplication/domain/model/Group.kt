package com.example.splitshareaplication.domain.model

data class Group(
    val id: String,
    val name: String,
    val description: String?,
    val createdByUserId: String,
    val defaultCurrency: String,
    val createdAtEpoch: Long,
    val members: List<GroupMember>
)
