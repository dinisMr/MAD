package com.example.splitshareaplication.domain.model

data class GroupMember(
    val userId: String,
    val name: String,
    val email: String,
    val role: MemberRole
)
