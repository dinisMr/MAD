package com.example.splitshareaplication.data.mapper

import com.example.splitshareaplication.data.remote.dto.ExpenseDto
import com.example.splitshareaplication.data.remote.dto.GroupDto
import com.example.splitshareaplication.data.remote.dto.SettlementDto
import com.example.splitshareaplication.data.remote.dto.UserDto
import com.example.splitshareaplication.domain.model.AppUser
import com.example.splitshareaplication.domain.model.Expense
import com.example.splitshareaplication.domain.model.Group
import com.example.splitshareaplication.domain.model.GroupMember
import com.example.splitshareaplication.domain.model.MemberRole
import com.example.splitshareaplication.domain.model.Settlement

fun UserDto.toDomain(): AppUser = AppUser(id = id, name = name, email = email)

fun GroupDto.toDomain(): Group = Group(
    id = id,
    name = name,
    description = description,
    createdByUserId = createdByUserId,
    defaultCurrency = defaultCurrency,
    createdAtEpoch = createdAtEpoch,
    members = memberIds.map { GroupMember(it, "Member $it", "$it@example.com", MemberRole.MEMBER) }
)

fun Group.toDto(): GroupDto = GroupDto(
    id = id,
    name = name,
    description = description,
    createdByUserId = createdByUserId,
    defaultCurrency = defaultCurrency,
    createdAtEpoch = createdAtEpoch,
    memberIds = members.map { it.userId }
)

fun ExpenseDto.toDomain(): Expense = Expense(
    id = id,
    groupId = groupId,
    title = title,
    amount = amount,
    currency = currency,
    category = category,
    paidByUserId = paidByUserId,
    dateEpoch = dateEpoch,
    participants = emptyList(),
    note = note
)

fun Expense.toDto(): ExpenseDto = ExpenseDto(
    id = id,
    groupId = groupId,
    title = title,
    amount = amount,
    currency = currency,
    category = category,
    paidByUserId = paidByUserId,
    dateEpoch = dateEpoch,
    participantIds = participants.map { it.userId },
    note = note
)

fun SettlementDto.toDomain(): Settlement = Settlement(
    id = id,
    groupId = groupId,
    fromUserId = fromUserId,
    toUserId = toUserId,
    amount = amount,
    currency = currency,
    dateEpoch = dateEpoch
)

fun Settlement.toDto(): SettlementDto = SettlementDto(
    id = id,
    groupId = groupId,
    fromUserId = fromUserId,
    toUserId = toUserId,
    amount = amount,
    currency = currency,
    dateEpoch = dateEpoch
)
