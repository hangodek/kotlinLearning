package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface() {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtIdentifier by remember { mutableStateOf(1) }

    val currentArt = when (currentArtIdentifier) {
        1 -> R.drawable.chad
        2 -> R.drawable.npc
        3 -> R.drawable.daikichi
        4 -> R.drawable.wife
        else -> R.drawable.chad
    }

    val currentArtDescription = when (currentArtIdentifier) {
        1 -> R.string.description_chad
        2 -> R.string.description_npc
        3 -> R.string.description_daikichi
        4 -> R.string.description_wife
        else -> R.string.description_chad
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        ImageContainer(picture = currentArt, contentDescription = currentArtDescription)

        Spacer(modifier = Modifier.height(50.dp))

        TextContainer(text = currentArtDescription)

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            MyButton(onClick = { currentArtIdentifier = maxOf(1, currentArtIdentifier - 1) }, text = R.string.previous_btn)
            MyButton(onClick = { currentArtIdentifier = minOf(4, currentArtIdentifier + 1) }, text = R.string.next_btn)
        }
    }
}

@Composable
fun ImageContainer(@DrawableRes picture: Int, contentDescription: Int) {
    Box(modifier = Modifier
        .shadow(3.dp, shape = RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(picture),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .padding(24.dp)
                .height(400.dp)
                .width(350.dp)
        )
    }
}


@Composable
fun TextContainer(@StringRes text: Int) {
    Box(modifier = Modifier
        .background(color = Color.Black, shape = RoundedCornerShape(8.dp))
        .padding(16.dp)) {
        Text(
            text = stringResource(text),
            color = Color.White
        )
    }
}

@Composable
fun MyButton(onClick: () -> Unit, @StringRes text: Int) {
    Button(onClick = { onClick() }) {
        Text(
            text = stringResource(text)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}