#!/usr/bin/env python3
# create_split_share_project3.py
# Run this file in the ROOT folder of your Android Studio project.
# It creates the Project 3 skeleton for the SplitShareAplication app automatically.

from pathlib import Path
import textwrap

PACKAGE = "com.example.splitshareaplication"
PACKAGE_PATH = PACKAGE.replace(".", "/")

ROOT = Path.cwd()
APP = ROOT / "app"
SRC = APP / "src" / "main"
KOTLIN = SRC / "java" / PACKAGE_PATH

def write_file(path: Path, content: str):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).strip() + "\n", encoding="utf-8")
    print(f"created/updated: {path}")

def main():
    # ---------- Root Gradle files ----------
    write_file(ROOT / "settings.gradle.kts", """
        pluginManagement {
            repositories {
                google()
                mavenCentral()
                gradlePluginPortal()
            }
        }

        dependencyResolutionManagement {
            repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
            repositories {
                google()
                mavenCentral()
            }
        }

        rootProject.name = "SplitShareAplication"
        include(":app")
    """)

    write_file(ROOT / "build.gradle.kts", """
        plugins {
            id("com.android.application") version "8.5.2" apply false
            id("org.jetbrains.kotlin.android") version "2.0.20" apply false
            id("com.google.devtools.ksp") version "2.0.20-1.0.24" apply false
            id("com.google.dagger.hilt.android") version "2.51.1" apply false
        }
    """)

    write_file(ROOT / ".gitignore", """
        *.iml
        .gradle/
        /local.properties
        /.idea/
        .DS_Store
        /build/
        /captures/
        .externalNativeBuild/
        .cxx/
        local.properties
        /app/build/
        google-services.json
    """)

    write_file(ROOT / "README.md", """
        # SplitShareAplication

        SplitShareAplication is an advanced Android application for managing shared expenses in groups such as trips, households, and dinners.

        ## Complexity level
        Advanced

        ## Main technologies
        - Kotlin
        - Jetpack Compose
        - ViewModel + StateFlow
        - Repository pattern
        - Hilt dependency injection
        - Room local database
        - Retrofit for ExchangeRate-API
        - Firebase contracts prepared for Authentication, Firestore, and notifications

        ## Build instructions
        1. Open this folder in Android Studio.
        2. Let Gradle sync.
        3. Run the app on an emulator or Android device.

        ## Notes
        This is the Project Class 3 skeleton. It contains the required `ui/`, `data/`, `domain/`, and `di/` packages, data models, DAO contracts, Retrofit service, repository interfaces, repository implementations, and a simple runnable Compose UI using sample local state.
    """)

    # ---------- App Gradle ----------
    write_file(APP / "build.gradle.kts", f"""
        plugins {{
            id("com.android.application")
            id("org.jetbrains.kotlin.android")
            id("com.google.devtools.ksp")
            id("com.google.dagger.hilt.android")
        }}

        android {{
            namespace = "{PACKAGE}"
            compileSdk = 35

            defaultConfig {{
                applicationId = "{PACKAGE}"
                minSdk = 26
                targetSdk = 35
                versionCode = 1
                versionName = "1.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }}

            buildFeatures {{
                compose = true
                buildConfig = true
            }}

            composeOptions {{
                kotlinCompilerExtensionVersion = "1.5.15"
            }}

            buildTypes {{
                release {{
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }}
            }}

            compileOptions {{
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }}

            kotlinOptions {{
                jvmTarget = "17"
            }}
        }}

        dependencies {{
            implementation(platform("androidx.compose:compose-bom:2024.09.00"))
            implementation("androidx.core:core-ktx:1.13.1")
            implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
            implementation("androidx.activity:activity-compose:1.9.2")
            implementation("androidx.compose.ui:ui")
            implementation("androidx.compose.ui:ui-graphics")
            implementation("androidx.compose.ui:ui-tooling-preview")
            implementation("androidx.compose.material3:material3")
            implementation("androidx.navigation:navigation-compose:2.8.0")
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")

            implementation("androidx.room:room-runtime:2.6.1")
            implementation("androidx.room:room-ktx:2.6.1")
            ksp("androidx.room:room-compiler:2.6.1")

            implementation("com.squareup.retrofit2:retrofit:2.11.0")
            implementation("com.squareup.retrofit2:converter-gson:2.11.0")
            implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

            implementation("com.google.dagger:hilt-android:2.51.1")
            ksp("com.google.dagger:hilt-compiler:2.51.1")
            implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

            implementation(platform("com.google.firebase:firebase-bom:33.2.0"))
            implementation("com.google.firebase:firebase-auth-ktx")
            implementation("com.google.firebase:firebase-firestore-ktx")
            implementation("com.google.firebase:firebase-messaging-ktx")

            testImplementation("junit:junit:4.13.2")
            androidTestImplementation("androidx.test.ext:junit:1.2.1")
            androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
            androidTestImplementation(platform("androidx.compose:compose-bom:2024.09.00"))
            androidTestImplementation("androidx.compose.ui:ui-test-junit4")
            debugImplementation("androidx.compose.ui:ui-tooling")
            debugImplementation("androidx.compose.ui:ui-test-manifest")
        }}
    """)

    write_file(APP / "proguard-rules.pro", "")

    write_file(SRC / "AndroidManifest.xml", f"""
        <manifest xmlns:android="http://schemas.android.com/apk/res/android">
            <uses-permission android:name="android.permission.INTERNET" />
            <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

            <application
                android:name=".SplitShareAplication"
                android:allowBackup="true"
                android:icon="@mipmap/ic_launcher"
                android:label="SplitShareAplication"
                android:roundIcon="@mipmap/ic_launcher_round"
                android:supportsRtl="true"
                android:theme="@style/Theme.SplitShare">
                <activity
                    android:name=".MainActivity"
                    android:exported="true">
                    <intent-filter>
                        <action android:name="android.intent.action.MAIN" />
                        <category android:name="android.intent.category.LAUNCHER" />
                    </intent-filter>
                </activity>
            </application>
        </manifest>
    """)

    write_file(SRC / "res" / "values" / "themes.xml", """
        <resources>
            <style name="Theme.SplitShare" parent="android:style/Theme.Material.Light.NoActionBar">
                <item name="android:windowLightStatusBar">true</item>
            </style>
        </resources>
    """)

    # ---------- App entry ----------
    write_file(KOTLIN / "SplitShareAplication.kt", f"""
        package {PACKAGE}

        import android.app.Application
        import dagger.hilt.android.HiltAndroidApp

        @HiltAndroidApp
        class SplitShareAplication : Application()
    """)

    write_file(KOTLIN / "MainActivity.kt", f"""
        package {PACKAGE}

        import android.os.Bundle
        import androidx.activity.ComponentActivity
        import androidx.activity.compose.setContent
        import androidx.compose.material3.MaterialTheme
        import androidx.compose.material3.Surface
        import androidx.hilt.navigation.compose.hiltViewModel
        import {PACKAGE}.ui.home.HomeScreen
        import {PACKAGE}.ui.home.HomeViewModel
        import dagger.hilt.android.AndroidEntryPoint

        @AndroidEntryPoint
        class MainActivity : ComponentActivity() {{
            override fun onCreate(savedInstanceState: Bundle?) {{
                super.onCreate(savedInstanceState)
                setContent {{
                    MaterialTheme {{
                        Surface {{
                            val viewModel: HomeViewModel = hiltViewModel()
                            HomeScreen(viewModel = viewModel)
                        }}
                    }}
                }}
            }}
        }}
    """)

    # ---------- Domain models ----------
    write_file(KOTLIN / "domain" / "model" / "AppUser.kt", f"""
        package {PACKAGE}.domain.model

        data class AppUser(
            val id: String,
            val name: String,
            val email: String
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "MemberRole.kt", f"""
        package {PACKAGE}.domain.model

        enum class MemberRole {{
            OWNER,
            MEMBER
        }}
    """)

    write_file(KOTLIN / "domain" / "model" / "GroupMember.kt", f"""
        package {PACKAGE}.domain.model

        data class GroupMember(
            val userId: String,
            val name: String,
            val email: String,
            val role: MemberRole
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "Group.kt", f"""
        package {PACKAGE}.domain.model

        data class Group(
            val id: String,
            val name: String,
            val description: String?,
            val createdByUserId: String,
            val defaultCurrency: String,
            val createdAtEpoch: Long,
            val members: List<GroupMember>
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "ExpenseSplit.kt", f"""
        package {PACKAGE}.domain.model

        data class ExpenseSplit(
            val userId: String,
            val shareAmount: Double,
            val isPaid: Boolean
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "Expense.kt", f"""
        package {PACKAGE}.domain.model

        data class Expense(
            val id: String,
            val groupId: String,
            val title: String,
            val amount: Double,
            val currency: String,
            val category: String,
            val paidByUserId: String,
            val dateEpoch: Long,
            val participants: List<ExpenseSplit>,
            val note: String?
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "Settlement.kt", f"""
        package {PACKAGE}.domain.model

        data class Settlement(
            val id: String,
            val groupId: String,
            val fromUserId: String,
            val toUserId: String,
            val amount: Double,
            val currency: String,
            val dateEpoch: Long
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "Balance.kt", f"""
        package {PACKAGE}.domain.model

        data class Balance(
            val fromUserId: String,
            val toUserId: String,
            val amount: Double,
            val currency: String
        )
    """)

    write_file(KOTLIN / "domain" / "model" / "CurrencyRate.kt", f"""
        package {PACKAGE}.domain.model

        data class CurrencyRate(
            val baseCurrency: String,
            val targetCurrency: String,
            val rate: Double,
            val fetchedAtEpoch: Long
        )
    """)

    # ---------- Repository interfaces ----------
    write_file(KOTLIN / "domain" / "repository" / "AuthRepository.kt", f"""
        package {PACKAGE}.domain.repository

        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.domain.model.AppUser

        interface AuthRepository {{
            val currentUser: Flow<AppUser?>
            suspend fun signIn(email: String, password: String): Result<AppUser>
            suspend fun signUp(name: String, email: String, password: String): Result<AppUser>
            suspend fun signOut()
        }}
    """)

    write_file(KOTLIN / "domain" / "repository" / "GroupRepository.kt", f"""
        package {PACKAGE}.domain.repository

        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.domain.model.Group

        interface GroupRepository {{
            fun observeGroups(userId: String): Flow<List<Group>>
            suspend fun createGroup(group: Group): Result<Unit>
            suspend fun updateGroup(group: Group): Result<Unit>
            suspend fun deleteGroup(groupId: String): Result<Unit>
        }}
    """)

    write_file(KOTLIN / "domain" / "repository" / "ExpenseRepository.kt", f"""
        package {PACKAGE}.domain.repository

        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.domain.model.Expense

        interface ExpenseRepository {{
            fun observeExpenses(groupId: String): Flow<List<Expense>>
            suspend fun addExpense(expense: Expense): Result<Unit>
            suspend fun updateExpense(expense: Expense): Result<Unit>
            suspend fun deleteExpense(expenseId: String): Result<Unit>
        }}
    """)

    write_file(KOTLIN / "domain" / "repository" / "SettlementRepository.kt", f"""
        package {PACKAGE}.domain.repository

        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.domain.model.Settlement

        interface SettlementRepository {{
            fun observeSettlements(groupId: String): Flow<List<Settlement>>
            suspend fun addSettlement(settlement: Settlement): Result<Unit>
        }}
    """)

    write_file(KOTLIN / "domain" / "repository" / "BalanceRepository.kt", f"""
        package {PACKAGE}.domain.repository

        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.domain.model.Balance

        interface BalanceRepository {{
            fun observeBalances(groupId: String): Flow<List<Balance>>
            suspend fun calculateBalances(groupId: String): Result<List<Balance>>
        }}
    """)

    write_file(KOTLIN / "domain" / "repository" / "CurrencyRepository.kt", f"""
        package {PACKAGE}.domain.repository

        interface CurrencyRepository {{
            suspend fun convert(amount: Double, fromCurrency: String, toCurrency: String): Result<Double>
        }}
    """)

    write_file(KOTLIN / "domain" / "repository" / "NotificationRepository.kt", f"""
        package {PACKAGE}.domain.repository

        interface NotificationRepository {{
            suspend fun updateDeviceToken(userId: String, token: String): Result<Unit>
            suspend fun notifyExpenseAdded(groupId: String, expenseId: String): Result<Unit>
            suspend fun notifySettlementAdded(groupId: String, settlementId: String): Result<Unit>
        }}
    """)

    # ---------- DTOs ----------
    write_file(KOTLIN / "data" / "remote" / "dto" / "ExchangeRateResponseDto.kt", f"""
        package {PACKAGE}.data.remote.dto

        import com.google.gson.annotations.SerializedName

        data class ExchangeRateResponseDto(
            @SerializedName("result") val result: String,
            @SerializedName("base_code") val baseCode: String,
            @SerializedName("time_last_update_unix") val lastUpdateEpoch: Long,
            @SerializedName("conversion_rates") val conversionRates: Map<String, Double>
        )
    """)

    write_file(KOTLIN / "data" / "remote" / "dto" / "FirebaseDtos.kt", f"""
        package {PACKAGE}.data.remote.dto

        data class UserDto(
            val id: String = "",
            val name: String = "",
            val email: String = "",
            val fcmToken: String? = null
        )

        data class GroupDto(
            val id: String = "",
            val name: String = "",
            val description: String? = null,
            val createdByUserId: String = "",
            val defaultCurrency: String = "EUR",
            val createdAtEpoch: Long = 0L,
            val memberIds: List<String> = emptyList()
        )

        data class ExpenseDto(
            val id: String = "",
            val groupId: String = "",
            val title: String = "",
            val amount: Double = 0.0,
            val currency: String = "EUR",
            val category: String = "Other",
            val paidByUserId: String = "",
            val dateEpoch: Long = 0L,
            val participantIds: List<String> = emptyList(),
            val note: String? = null
        )

        data class ExpenseSplitDto(
            val expenseId: String = "",
            val userId: String = "",
            val shareAmount: Double = 0.0,
            val isPaid: Boolean = false
        )

        data class SettlementDto(
            val id: String = "",
            val groupId: String = "",
            val fromUserId: String = "",
            val toUserId: String = "",
            val amount: Double = 0.0,
            val currency: String = "EUR",
            val dateEpoch: Long = 0L
        )
    """)

    # ---------- Remote APIs ----------
    write_file(KOTLIN / "data" / "remote" / "ExchangeRateApiService.kt", f"""
        package {PACKAGE}.data.remote

        import retrofit2.Response
        import retrofit2.http.GET
        import retrofit2.http.Path
        import {PACKAGE}.data.remote.dto.ExchangeRateResponseDto

        interface ExchangeRateApiService {{
            @GET("v6/{{apiKey}}/latest/{{baseCurrency}}")
            suspend fun getLatestRates(
                @Path("apiKey") apiKey: String,
                @Path("baseCurrency") baseCurrency: String
            ): Response<ExchangeRateResponseDto>
        }}
    """)

    write_file(KOTLIN / "data" / "remote" / "FirebaseRemoteDataSource.kt", f"""
        package {PACKAGE}.data.remote

        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.data.remote.dto.ExpenseDto
        import {PACKAGE}.data.remote.dto.GroupDto
        import {PACKAGE}.data.remote.dto.SettlementDto
        import {PACKAGE}.data.remote.dto.UserDto

        interface FirebaseRemoteDataSource {{
            suspend fun signIn(email: String, password: String): UserDto
            suspend fun signUp(name: String, email: String, password: String): UserDto
            suspend fun signOut()
            fun observeGroups(userId: String): Flow<List<GroupDto>>
            suspend fun createGroup(group: GroupDto)
            suspend fun updateGroup(group: GroupDto)
            suspend fun deleteGroup(groupId: String)
            fun observeExpenses(groupId: String): Flow<List<ExpenseDto>>
            suspend fun addExpense(expense: ExpenseDto)
            suspend fun updateExpense(expense: ExpenseDto)
            suspend fun deleteExpense(expenseId: String)
            fun observeSettlements(groupId: String): Flow<List<SettlementDto>>
            suspend fun addSettlement(settlement: SettlementDto)
            suspend fun saveFcmToken(userId: String, token: String)
        }}
    """)

    write_file(KOTLIN / "data" / "remote" / "FakeFirebaseRemoteDataSource.kt", f"""
        package {PACKAGE}.data.remote

        import kotlinx.coroutines.flow.Flow
        import kotlinx.coroutines.flow.MutableStateFlow
        import {PACKAGE}.data.remote.dto.ExpenseDto
        import {PACKAGE}.data.remote.dto.GroupDto
        import {PACKAGE}.data.remote.dto.SettlementDto
        import {PACKAGE}.data.remote.dto.UserDto
        import javax.inject.Inject
        import javax.inject.Singleton

        @Singleton
        class FakeFirebaseRemoteDataSource @Inject constructor() : FirebaseRemoteDataSource {{
            private val user = MutableStateFlow(UserDto("u1", "Demo User", "demo@splitshare.com"))
            private val groups = MutableStateFlow<List<GroupDto>>(
                listOf(
                    GroupDto(
                        id = "g1",
                        name = "Barcelona Trip",
                        description = "Shared travel expenses",
                        createdByUserId = "u1",
                        defaultCurrency = "EUR",
                        createdAtEpoch = System.currentTimeMillis()
                    )
                )
            )
            private val expenses = MutableStateFlow<List<ExpenseDto>>(
                listOf(
                    ExpenseDto("e1", "g1", "Dinner", 48.0, "EUR", "Food", "u1", System.currentTimeMillis(), listOf("u1", "u2")),
                    ExpenseDto("e2", "g1", "Train tickets", 32.0, "EUR", "Transport", "u2", System.currentTimeMillis(), listOf("u1", "u2"))
                )
            )
            private val settlements = MutableStateFlow<List<SettlementDto>>(emptyList())

            override suspend fun signIn(email: String, password: String): UserDto = user.value
            override suspend fun signUp(name: String, email: String, password: String): UserDto = UserDto("u1", name, email)
            override suspend fun signOut() = Unit

            override fun observeGroups(userId: String): Flow<List<GroupDto>> = groups
            override suspend fun createGroup(group: GroupDto) {{ groups.value = groups.value + group }}
            override suspend fun updateGroup(group: GroupDto) {{ groups.value = groups.value.map {{ if (it.id == group.id) group else it }} }}
            override suspend fun deleteGroup(groupId: String) {{ groups.value = groups.value.filterNot {{ it.id == groupId }} }}

            override fun observeExpenses(groupId: String): Flow<List<ExpenseDto>> = expenses
            override suspend fun addExpense(expense: ExpenseDto) {{ expenses.value = expenses.value + expense }}
            override suspend fun updateExpense(expense: ExpenseDto) {{ expenses.value = expenses.value.map {{ if (it.id == expense.id) expense else it }} }}
            override suspend fun deleteExpense(expenseId: String) {{ expenses.value = expenses.value.filterNot {{ it.id == expenseId }} }}

            override fun observeSettlements(groupId: String): Flow<List<SettlementDto>> = settlements
            override suspend fun addSettlement(settlement: SettlementDto) {{ settlements.value = settlements.value + settlement }}
            override suspend fun saveFcmToken(userId: String, token: String) = Unit
        }}
    """)

    # ---------- Room entities ----------
    write_file(KOTLIN / "data" / "local" / "entity" / "Entities.kt", f"""
        package {PACKAGE}.data.local.entity

        import androidx.room.Entity
        import androidx.room.PrimaryKey

        @Entity(tableName = "users")
        data class UserEntity(
            @PrimaryKey val id: String,
            val name: String,
            val email: String
        )

        @Entity(tableName = "groups")
        data class GroupEntity(
            @PrimaryKey val id: String,
            val name: String,
            val description: String?,
            val createdByUserId: String,
            val defaultCurrency: String,
            val createdAtEpoch: Long
        )

        @Entity(tableName = "group_members", primaryKeys = ["groupId", "userId"])
        data class GroupMemberEntity(
            val groupId: String,
            val userId: String,
            val role: String
        )

        @Entity(tableName = "expenses")
        data class ExpenseEntity(
            @PrimaryKey val id: String,
            val groupId: String,
            val title: String,
            val amount: Double,
            val currency: String,
            val category: String,
            val paidByUserId: String,
            val dateEpoch: Long,
            val note: String?
        )

        @Entity(tableName = "expense_splits", primaryKeys = ["expenseId", "userId"])
        data class ExpenseSplitEntity(
            val expenseId: String,
            val userId: String,
            val shareAmount: Double,
            val isPaid: Boolean
        )

        @Entity(tableName = "settlements")
        data class SettlementEntity(
            @PrimaryKey val id: String,
            val groupId: String,
            val fromUserId: String,
            val toUserId: String,
            val amount: Double,
            val currency: String,
            val dateEpoch: Long
        )

        @Entity(tableName = "currency_rates", primaryKeys = ["baseCurrency", "targetCurrency"])
        data class CurrencyRateEntity(
            val baseCurrency: String,
            val targetCurrency: String,
            val rate: Double,
            val fetchedAtEpoch: Long
        )
    """)

    # ---------- DAOs ----------
    write_file(KOTLIN / "data" / "local" / "dao" / "Daos.kt", f"""
        package {PACKAGE}.data.local.dao

        import androidx.room.Dao
        import androidx.room.Insert
        import androidx.room.OnConflictStrategy
        import androidx.room.Query
        import kotlinx.coroutines.flow.Flow
        import {PACKAGE}.data.local.entity.CurrencyRateEntity
        import {PACKAGE}.data.local.entity.ExpenseEntity
        import {PACKAGE}.data.local.entity.ExpenseSplitEntity
        import {PACKAGE}.data.local.entity.GroupEntity
        import {PACKAGE}.data.local.entity.GroupMemberEntity
        import {PACKAGE}.data.local.entity.SettlementEntity

        @Dao
        interface GroupDao {{
            @Query("SELECT * FROM groups ORDER BY createdAtEpoch DESC")
            fun observeGroups(): Flow<List<GroupEntity>>

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertGroups(groups: List<GroupEntity>)

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertGroup(group: GroupEntity)

            @Query("DELETE FROM groups WHERE id = :groupId")
            suspend fun deleteGroup(groupId: String)
        }}

        @Dao
        interface GroupMemberDao {{
            @Query("SELECT * FROM group_members WHERE groupId = :groupId")
            fun observeMembers(groupId: String): Flow<List<GroupMemberEntity>>

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertMembers(members: List<GroupMemberEntity>)
        }}

        @Dao
        interface ExpenseDao {{
            @Query("SELECT * FROM expenses WHERE groupId = :groupId ORDER BY dateEpoch DESC")
            fun observeExpenses(groupId: String): Flow<List<ExpenseEntity>>

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertExpense(expense: ExpenseEntity)

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertExpenses(expenses: List<ExpenseEntity>)

            @Query("DELETE FROM expenses WHERE id = :expenseId")
            suspend fun deleteExpense(expenseId: String)
        }}

        @Dao
        interface ExpenseSplitDao {{
            @Query("SELECT * FROM expense_splits WHERE expenseId = :expenseId")
            fun observeSplits(expenseId: String): Flow<List<ExpenseSplitEntity>>

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertSplits(splits: List<ExpenseSplitEntity>)
        }}

        @Dao
        interface SettlementDao {{
            @Query("SELECT * FROM settlements WHERE groupId = :groupId ORDER BY dateEpoch DESC")
            fun observeSettlements(groupId: String): Flow<List<SettlementEntity>>

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertSettlement(settlement: SettlementEntity)
        }}

        @Dao
        interface CurrencyRateDao {{
            @Query("SELECT * FROM currency_rates WHERE baseCurrency = :base AND targetCurrency = :target")
            suspend fun getRate(base: String, target: String): CurrencyRateEntity?

            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertRate(rate: CurrencyRateEntity)
        }}
    """)

    write_file(KOTLIN / "data" / "local" / "AppDatabase.kt", f"""
        package {PACKAGE}.data.local

        import androidx.room.Database
        import androidx.room.RoomDatabase
        import {PACKAGE}.data.local.dao.CurrencyRateDao
        import {PACKAGE}.data.local.dao.ExpenseDao
        import {PACKAGE}.data.local.dao.ExpenseSplitDao
        import {PACKAGE}.data.local.dao.GroupDao
        import {PACKAGE}.data.local.dao.GroupMemberDao
        import {PACKAGE}.data.local.dao.SettlementDao
        import {PACKAGE}.data.local.entity.CurrencyRateEntity
        import {PACKAGE}.data.local.entity.ExpenseEntity
        import {PACKAGE}.data.local.entity.ExpenseSplitEntity
        import {PACKAGE}.data.local.entity.GroupEntity
        import {PACKAGE}.data.local.entity.GroupMemberEntity
        import {PACKAGE}.data.local.entity.SettlementEntity
        import {PACKAGE}.data.local.entity.UserEntity

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
        abstract class AppDatabase : RoomDatabase() {{
            abstract fun groupDao(): GroupDao
            abstract fun groupMemberDao(): GroupMemberDao
            abstract fun expenseDao(): ExpenseDao
            abstract fun expenseSplitDao(): ExpenseSplitDao
            abstract fun settlementDao(): SettlementDao
            abstract fun currencyRateDao(): CurrencyRateDao
        }}
    """)

    # ---------- Mappers ----------
    write_file(KOTLIN / "data" / "mapper" / "Mappers.kt", f"""
        package {PACKAGE}.data.mapper

        import {PACKAGE}.data.remote.dto.ExpenseDto
        import {PACKAGE}.data.remote.dto.GroupDto
        import {PACKAGE}.data.remote.dto.SettlementDto
        import {PACKAGE}.data.remote.dto.UserDto
        import {PACKAGE}.domain.model.AppUser
        import {PACKAGE}.domain.model.Expense
        import {PACKAGE}.domain.model.Group
        import {PACKAGE}.domain.model.GroupMember
        import {PACKAGE}.domain.model.MemberRole
        import {PACKAGE}.domain.model.Settlement

        fun UserDto.toDomain(): AppUser = AppUser(id = id, name = name, email = email)

        fun GroupDto.toDomain(): Group = Group(
            id = id,
            name = name,
            description = description,
            createdByUserId = createdByUserId,
            defaultCurrency = defaultCurrency,
            createdAtEpoch = createdAtEpoch,
            members = memberIds.map {{ GroupMember(it, "Member $it", "$it@example.com", MemberRole.MEMBER) }}
        )

        fun Group.toDto(): GroupDto = GroupDto(
            id = id,
            name = name,
            description = description,
            createdByUserId = createdByUserId,
            defaultCurrency = defaultCurrency,
            createdAtEpoch = createdAtEpoch,
            memberIds = members.map {{ it.userId }}
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
            participantIds = participants.map {{ it.userId }},
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
    """)

    # ---------- Repository implementations ----------
    write_file(KOTLIN / "data" / "repository" / "Repositories.kt", f"""
        package {PACKAGE}.data.repository

        import kotlinx.coroutines.flow.Flow
        import kotlinx.coroutines.flow.MutableStateFlow
        import kotlinx.coroutines.flow.map
        import {PACKAGE}.data.mapper.toDomain
        import {PACKAGE}.data.mapper.toDto
        import {PACKAGE}.data.remote.FirebaseRemoteDataSource
        import {PACKAGE}.domain.model.AppUser
        import {PACKAGE}.domain.model.Balance
        import {PACKAGE}.domain.model.Expense
        import {PACKAGE}.domain.model.Group
        import {PACKAGE}.domain.model.Settlement
        import {PACKAGE}.domain.repository.AuthRepository
        import {PACKAGE}.domain.repository.BalanceRepository
        import {PACKAGE}.domain.repository.CurrencyRepository
        import {PACKAGE}.domain.repository.ExpenseRepository
        import {PACKAGE}.domain.repository.GroupRepository
        import {PACKAGE}.domain.repository.NotificationRepository
        import {PACKAGE}.domain.repository.SettlementRepository
        import javax.inject.Inject
        import javax.inject.Singleton

        @Singleton
        class AuthRepositoryImpl @Inject constructor(
            private val remote: FirebaseRemoteDataSource
        ) : AuthRepository {{
            private val _currentUser = MutableStateFlow<AppUser?>(AppUser("u1", "Demo User", "demo@splitshare.com"))
            override val currentUser: Flow<AppUser?> = _currentUser

            override suspend fun signIn(email: String, password: String): Result<AppUser> =
                runCatching {{ remote.signIn(email, password).toDomain().also {{ _currentUser.value = it }} }}

            override suspend fun signUp(name: String, email: String, password: String): Result<AppUser> =
                runCatching {{ remote.signUp(name, email, password).toDomain().also {{ _currentUser.value = it }} }}

            override suspend fun signOut() {{
                remote.signOut()
                _currentUser.value = null
            }}
        }}

        @Singleton
        class GroupRepositoryImpl @Inject constructor(
            private val remote: FirebaseRemoteDataSource
        ) : GroupRepository {{
            override fun observeGroups(userId: String): Flow<List<Group>> =
                remote.observeGroups(userId).map {{ list -> list.map {{ it.toDomain() }} }}

            override suspend fun createGroup(group: Group): Result<Unit> =
                runCatching {{ remote.createGroup(group.toDto()) }}

            override suspend fun updateGroup(group: Group): Result<Unit> =
                runCatching {{ remote.updateGroup(group.toDto()) }}

            override suspend fun deleteGroup(groupId: String): Result<Unit> =
                runCatching {{ remote.deleteGroup(groupId) }}
        }}

        @Singleton
        class ExpenseRepositoryImpl @Inject constructor(
            private val remote: FirebaseRemoteDataSource
        ) : ExpenseRepository {{
            override fun observeExpenses(groupId: String): Flow<List<Expense>> =
                remote.observeExpenses(groupId).map {{ list -> list.map {{ it.toDomain() }} }}

            override suspend fun addExpense(expense: Expense): Result<Unit> =
                runCatching {{ remote.addExpense(expense.toDto()) }}

            override suspend fun updateExpense(expense: Expense): Result<Unit> =
                runCatching {{ remote.updateExpense(expense.toDto()) }}

            override suspend fun deleteExpense(expenseId: String): Result<Unit> =
                runCatching {{ remote.deleteExpense(expenseId) }}
        }}

        @Singleton
        class SettlementRepositoryImpl @Inject constructor(
            private val remote: FirebaseRemoteDataSource
        ) : SettlementRepository {{
            override fun observeSettlements(groupId: String): Flow<List<Settlement>> =
                remote.observeSettlements(groupId).map {{ list -> list.map {{ it.toDomain() }} }}

            override suspend fun addSettlement(settlement: Settlement): Result<Unit> =
                runCatching {{ remote.addSettlement(settlement.toDto()) }}
        }}

        @Singleton
        class BalanceRepositoryImpl @Inject constructor() : BalanceRepository {{
            private val balances = MutableStateFlow(
                listOf(Balance("u2", "u1", 40.0, "EUR"))
            )

            override fun observeBalances(groupId: String): Flow<List<Balance>> = balances

            override suspend fun calculateBalances(groupId: String): Result<List<Balance>> =
                Result.success(balances.value)
        }}

        @Singleton
        class CurrencyRepositoryImpl @Inject constructor() : CurrencyRepository {{
            override suspend fun convert(amount: Double, fromCurrency: String, toCurrency: String): Result<Double> {{
                val result = if (fromCurrency == toCurrency) amount else amount * 4.25
                return Result.success(result)
            }}
        }}

        @Singleton
        class NotificationRepositoryImpl @Inject constructor() : NotificationRepository {{
            override suspend fun updateDeviceToken(userId: String, token: String): Result<Unit> = Result.success(Unit)
            override suspend fun notifyExpenseAdded(groupId: String, expenseId: String): Result<Unit> = Result.success(Unit)
            override suspend fun notifySettlementAdded(groupId: String, settlementId: String): Result<Unit> = Result.success(Unit)
        }}
    """)

    # ---------- DI ----------
    write_file(KOTLIN / "di" / "AppModule.kt", f"""
        package {PACKAGE}.di

        import android.content.Context
        import androidx.room.Room
        import dagger.Module
        import dagger.Provides
        import dagger.hilt.InstallIn
        import dagger.hilt.android.qualifiers.ApplicationContext
        import dagger.hilt.components.SingletonComponent
        import retrofit2.Retrofit
        import retrofit2.converter.gson.GsonConverterFactory
        import {PACKAGE}.data.local.AppDatabase
        import {PACKAGE}.data.remote.ExchangeRateApiService
        import {PACKAGE}.data.remote.FakeFirebaseRemoteDataSource
        import {PACKAGE}.data.remote.FirebaseRemoteDataSource
        import javax.inject.Singleton

        @Module
        @InstallIn(SingletonComponent::class)
        object AppModule {{
            @Provides
            @Singleton
            fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, "split_share.db")
                    .fallbackToDestructiveMigration()
                    .build()

            @Provides
            @Singleton
            fun provideRetrofit(): Retrofit =
                Retrofit.Builder()
                    .baseUrl("https://v6.exchangerate-api.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            @Provides
            @Singleton
            fun provideExchangeRateApiService(retrofit: Retrofit): ExchangeRateApiService =
                retrofit.create(ExchangeRateApiService::class.java)

            @Provides
            @Singleton
            fun provideFirebaseRemoteDataSource(fake: FakeFirebaseRemoteDataSource): FirebaseRemoteDataSource = fake
        }}
    """)

    write_file(KOTLIN / "di" / "RepositoryModule.kt", f"""
        package {PACKAGE}.di

        import dagger.Binds
        import dagger.Module
        import dagger.hilt.InstallIn
        import dagger.hilt.components.SingletonComponent
        import {PACKAGE}.data.repository.AuthRepositoryImpl
        import {PACKAGE}.data.repository.BalanceRepositoryImpl
        import {PACKAGE}.data.repository.CurrencyRepositoryImpl
        import {PACKAGE}.data.repository.ExpenseRepositoryImpl
        import {PACKAGE}.data.repository.GroupRepositoryImpl
        import {PACKAGE}.data.repository.NotificationRepositoryImpl
        import {PACKAGE}.data.repository.SettlementRepositoryImpl
        import {PACKAGE}.domain.repository.AuthRepository
        import {PACKAGE}.domain.repository.BalanceRepository
        import {PACKAGE}.domain.repository.CurrencyRepository
        import {PACKAGE}.domain.repository.ExpenseRepository
        import {PACKAGE}.domain.repository.GroupRepository
        import {PACKAGE}.domain.repository.NotificationRepository
        import {PACKAGE}.domain.repository.SettlementRepository
        import javax.inject.Singleton

        @Module
        @InstallIn(SingletonComponent::class)
        abstract class RepositoryModule {{
            @Binds @Singleton abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
            @Binds @Singleton abstract fun bindGroupRepository(impl: GroupRepositoryImpl): GroupRepository
            @Binds @Singleton abstract fun bindExpenseRepository(impl: ExpenseRepositoryImpl): ExpenseRepository
            @Binds @Singleton abstract fun bindSettlementRepository(impl: SettlementRepositoryImpl): SettlementRepository
            @Binds @Singleton abstract fun bindBalanceRepository(impl: BalanceRepositoryImpl): BalanceRepository
            @Binds @Singleton abstract fun bindCurrencyRepository(impl: CurrencyRepositoryImpl): CurrencyRepository
            @Binds @Singleton abstract fun bindNotificationRepository(impl: NotificationRepositoryImpl): NotificationRepository
        }}
    """)

    # ---------- UI ----------
    write_file(KOTLIN / "ui" / "home" / "HomeUiState.kt", f"""
        package {PACKAGE}.ui.home

        import {PACKAGE}.domain.model.Balance
        import {PACKAGE}.domain.model.Expense
        import {PACKAGE}.domain.model.Group

        data class HomeUiState(
            val isLoading: Boolean = false,
            val groups: List<Group> = emptyList(),
            val selectedGroupId: String = "g1",
            val expenses: List<Expense> = emptyList(),
            val balances: List<Balance> = emptyList(),
            val errorMessage: String? = null
        )
    """)

    write_file(KOTLIN / "ui" / "home" / "HomeViewModel.kt", f"""
        package {PACKAGE}.ui.home

        import androidx.lifecycle.ViewModel
        import androidx.lifecycle.viewModelScope
        import dagger.hilt.android.lifecycle.HiltViewModel
        import kotlinx.coroutines.flow.MutableStateFlow
        import kotlinx.coroutines.flow.StateFlow
        import kotlinx.coroutines.flow.asStateFlow
        import kotlinx.coroutines.flow.combine
        import kotlinx.coroutines.launch
        import {PACKAGE}.domain.model.Expense
        import {PACKAGE}.domain.model.ExpenseSplit
        import {PACKAGE}.domain.repository.BalanceRepository
        import {PACKAGE}.domain.repository.ExpenseRepository
        import {PACKAGE}.domain.repository.GroupRepository
        import javax.inject.Inject

        @HiltViewModel
        class HomeViewModel @Inject constructor(
            private val groupRepository: GroupRepository,
            private val expenseRepository: ExpenseRepository,
            private val balanceRepository: BalanceRepository
        ) : ViewModel() {{

            private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
            val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

            init {{
                loadDemoData()
            }}

            private fun loadDemoData() {{
                viewModelScope.launch {{
                    combine(
                        groupRepository.observeGroups("u1"),
                        expenseRepository.observeExpenses("g1"),
                        balanceRepository.observeBalances("g1")
                    ) {{ groups, expenses, balances ->
                        HomeUiState(
                            isLoading = false,
                            groups = groups,
                            selectedGroupId = "g1",
                            expenses = expenses,
                            balances = balances
                        )
                    }}.collect {{ state ->
                        _uiState.value = state
                    }}
                }}
            }}

            fun addDemoExpense() {{
                viewModelScope.launch {{
                    val newExpense = Expense(
                        id = "e" + System.currentTimeMillis(),
                        groupId = "g1",
                        title = "Coffee",
                        amount = 12.0,
                        currency = "EUR",
                        category = "Food",
                        paidByUserId = "u1",
                        dateEpoch = System.currentTimeMillis(),
                        participants = listOf(
                            ExpenseSplit("u1", 6.0, true),
                            ExpenseSplit("u2", 6.0, false)
                        ),
                        note = "Demo expense added from UI"
                    )
                    expenseRepository.addExpense(newExpense)
                }}
            }}
        }}
    """)

    write_file(KOTLIN / "ui" / "home" / "HomeScreen.kt", f"""
        package {PACKAGE}.ui.home

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
        import {PACKAGE}.domain.model.Balance
        import {PACKAGE}.domain.model.Expense
        import {PACKAGE}.domain.model.Group

        @Composable
        fun HomeScreen(viewModel: HomeViewModel) {{
            val state by viewModel.uiState.collectAsState()

            if (state.isLoading) {{
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {{
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Loading Split Share...")
                }}
                return
            }}

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {{
                item {{
                    Text(
                        text = "SplitShareAplication",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Project 3 Android skeleton",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }}

                item {{
                    Button(onClick = viewModel::addDemoExpense) {{
                        Text("Add demo expense")
                    }}
                }}

                item {{
                    SectionTitle("Groups")
                }}

                items(state.groups) {{ group ->
                    GroupCard(group)
                }}

                item {{
                    SectionTitle("Expenses")
                }}

                items(state.expenses) {{ expense ->
                    ExpenseCard(expense)
                }}

                item {{
                    SectionTitle("Balances")
                }}

                items(state.balances) {{ balance ->
                    BalanceCard(balance)
                }}
            }}
        }}

        @Composable
        private fun SectionTitle(text: String) {{
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }}

        @Composable
        private fun GroupCard(group: Group) {{
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {{
                Column(modifier = Modifier.padding(16.dp)) {{
                    Text(group.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(group.description ?: "No description")
                    Text("Default currency: ${{group.defaultCurrency}}")
                }}
            }}
        }}

        @Composable
        private fun ExpenseCard(expense: Expense) {{
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {{
                    Column {{
                        Text(expense.title, fontWeight = FontWeight.Bold)
                        Text(expense.category)
                    }}
                    Text("${{expense.amount}} ${{expense.currency}}", fontWeight = FontWeight.Bold)
                }}
            }}
        }}

        @Composable
        private fun BalanceCard(balance: Balance) {{
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {{
                Column(modifier = Modifier.padding(16.dp)) {{
                    Text("Debt", fontWeight = FontWeight.Bold)
                    Text("${{balance.fromUserId}} owes ${{balance.toUserId}}")
                    Text("${{balance.amount}} ${{balance.currency}}")
                }}
            }}
        }}
    """)

    # Extra stub screens to satisfy the requested architecture
    for folder, klass in [
        ("groups", "GroupDetailsScreen"),
        ("expense", "AddExpenseScreen"),
        ("history", "HistoryScreen"),
        ("auth", "LoginScreen"),
        ("navigation", "AppNavGraph")
    ]:
        write_file(KOTLIN / "ui" / folder / f"{klass}.kt", f"""
            package {PACKAGE}.ui.{folder}

            import androidx.compose.material3.Text
            import androidx.compose.runtime.Composable

            @Composable
            fun {klass}() {{
                Text("{klass} placeholder")
            }}
        """)

    print("\nDONE.")
    print("Open the folder in Android Studio, press Sync Gradle, then Run.")
    print("If your Android Studio project already had a different package name, this script uses: " + PACKAGE)

if __name__ == "__main__":
    main()
