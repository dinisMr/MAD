package com.example.lab3exerc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3Theme {
                Lab3App()
            }
        }
    }
}

data class Topic(
    val name: String,
    val courses: Int,
    val color: Color
)

data class DayPlan(
    val day: Int,
    val title: String,
    val description: String,
    val color: Color
)

val topics = listOf(
    Topic("Architecture", 58, Color(0xFF6750A4)),
    Topic("Crafts", 121, Color(0xFF7D5260)),
    Topic("Business", 78, Color(0xFF006A6A)),
    Topic("Culinary", 118, Color(0xFFB3261E)),
    Topic("Design", 423, Color(0xFF386A20)),
    Topic("Fashion", 92, Color(0xFF006C4C)),
    Topic("Film", 165, Color(0xFF904A42)),
    Topic("Gaming", 164, Color(0xFF5D5FEF)),
    Topic("Drawing", 326, Color(0xFF944F00)),
    Topic("Lifestyle", 305, Color(0xFF4A635E)),
    Topic("Music", 212, Color(0xFF6D5E0F)),
    Topic("Painting", 172, Color(0xFF005EB8))
)

val dayPlans = listOf(
    DayPlan(1, "Start with Kotlin basics", "Review variables, functions, classes, and small examples.", Color(0xFF6750A4)),
    DayPlan(2, "Build a simple layout", "Practice Column, Row, Text, and Modifier.padding.", Color(0xFF7D5260)),
    DayPlan(3, "Use Material Design", "Apply MaterialTheme, Card, and typography.", Color(0xFF006A6A)),
    DayPlan(4, "Create reusable composables", "Split the UI into small composable functions.", Color(0xFFB3261E)),
    DayPlan(5, "Add previews", "Use previews to check UI faster during development.", Color(0xFF386A20)),
    DayPlan(6, "Work with lists", "Display a list of data with LazyColumn.", Color(0xFF006C4C)),
    DayPlan(7, "Practice images", "Use simple visual blocks and clear descriptions.", Color(0xFF904A42)),
    DayPlan(8, "Improve spacing", "Use padding, height, width, and fillMaxWidth.", Color(0xFF5D5FEF)),
    DayPlan(9, "Create cards", "Put repeated items inside Material cards.", Color(0xFF944F00)),
    DayPlan(10, "Add top app bar", "Use Scaffold and TopAppBar for structure.", Color(0xFF4A635E)),
    DayPlan(11, "Make content scrollable", "Use LazyColumn for long screens.", Color(0xFF6D5E0F)),
    DayPlan(12, "Check accessibility", "Make the app easy to read and understand.", Color(0xFF005EB8)),
    DayPlan(13, "Use state", "Use remember and mutableStateOf for interaction.", Color(0xFF6750A4)),
    DayPlan(14, "Animate content", "Use animateContentSize for smooth expanding cards.", Color(0xFF7D5260)),
    DayPlan(15, "Build a grid", "Practice LazyVerticalGrid with course topics.", Color(0xFF006A6A)),
    DayPlan(16, "Organize code", "Keep data and composables clean.", Color(0xFFB3261E)),
    DayPlan(17, "Review modifiers", "Understand how modifier order changes layout.", Color(0xFF386A20)),
    DayPlan(18, "Test the app", "Run on emulator or phone and fix errors.", Color(0xFF006C4C)),
    DayPlan(19, "Clean imports", "Remove unused code before submitting.", Color(0xFF904A42)),
    DayPlan(20, "Commit to GitHub", "Upload the work to the private MAD repository.", Color(0xFF5D5FEF)),
    DayPlan(21, "Submit the link", "Send the repository link in Microsoft Teams.", Color(0xFF944F00)),
    DayPlan(22, "Review Unit 3", "Review lists, grids, and Material Design.", Color(0xFF4A635E)),
    DayPlan(23, "Practice Compose", "Repeat small UI exercises.", Color(0xFF6D5E0F)),
    DayPlan(24, "Improve typography", "Use title, label, and body text correctly.", Color(0xFF005EB8)),
    DayPlan(25, "Polish the UI", "Make spacing and style consistent.", Color(0xFF6750A4)),
    DayPlan(26, "Check Gradle", "Make sure the project builds correctly.", Color(0xFF7D5260)),
    DayPlan(27, "Check structure", "Confirm MAD/UNIT3/Grid and MAD/UNIT3/30DaysApp.", Color(0xFF006A6A)),
    DayPlan(28, "Run final test", "Open and run the app one last time.", Color(0xFFB3261E)),
    DayPlan(29, "Add collaborator", "Make sure the instructor is added to GitHub.", Color(0xFF386A20)),
    DayPlan(30, "Final submission", "Submit the private repository link.", Color(0xFF006C4C))
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lab3App() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(if (selectedTab == 0) "Courses Grid" else "30 Days App")
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Text("Grid") },
                    label = { Text("Courses") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Text("30") },
                    label = { Text("30 Days") }
                )
            }
        }
    ) { padding ->
        if (selectedTab == 0) {
            GridScreen(modifier = Modifier.padding(padding))
        } else {
            ThirtyDaysScreen(modifier = Modifier.padding(padding))
        }
    }
}

@Composable
fun GridScreen(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topics.size) { index ->
            TopicCard(topic = topics[index])
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(topic.color),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = topic.name.first().toString(),
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = topic.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.courses.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(dayPlans) { day ->
            DayCard(day)
        }
    }
}

@Composable
fun DayCard(day: DayPlan) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .animateContentSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(day.color),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Day ${day.day}",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Day ${day.day}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = day.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = if (expanded) day.description else "Tap to read more.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Lab3Theme(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}
