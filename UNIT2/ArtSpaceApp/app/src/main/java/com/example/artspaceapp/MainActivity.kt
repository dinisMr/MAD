package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

data class Artwork(
    @DrawableRes val imageResource: Int,
    val title: String,
    val artist: String,
    val year: String
)

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork(
            imageResource = R.drawable.artwork_one,
            title = "Mountain Morning",
            artist = "Ezgi Nak",
            year = "2026"
        ),
        Artwork(
            imageResource = R.drawable.artwork_two,
            title = "City Lights",
            artist = "Ezgi Nak",
            year = "2026"
        ),
        Artwork(
            imageResource = R.drawable.artwork_three,
            title = "Quiet Sea",
            artist = "Ezgi Nak",
            year = "2026"
        )
    )

    var currentArtworkIndex by remember {
        mutableIntStateOf(0)
    }

    val currentArtwork = artworks[currentArtworkIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtworkImage(
            imageResource = currentArtwork.imageResource,
            title = currentArtwork.title
        )

        Spacer(modifier = Modifier.height(32.dp))

        ArtworkInfo(
            title = currentArtwork.title,
            artist = currentArtwork.artist,
            year = currentArtwork.year
        )

        Spacer(modifier = Modifier.height(32.dp))

        NavigationButtons(
            onPreviousClick = {
                currentArtworkIndex =
                    if (currentArtworkIndex == 0) artworks.lastIndex else currentArtworkIndex - 1
            },
            onNextClick = {
                currentArtworkIndex =
                    if (currentArtworkIndex == artworks.lastIndex) 0 else currentArtworkIndex + 1
            }
        )
    }
}

@Composable
fun ArtworkImage(
    @DrawableRes imageResource: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = title,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(300.dp)
            .border(2.dp, Color.LightGray)
            .padding(8.dp)
    )
}

@Composable
fun ArtworkInfo(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFECECEC))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$artist ($year)",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun NavigationButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = "Previous")
        }

        Spacer(modifier = Modifier.width(24.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = "Next")
        }
    }
}