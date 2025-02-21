package com.example.artspace

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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

                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        ImageContainer(picture = R.drawable.chad, contentDescription = "The REAL CHADD")

        Spacer(modifier = Modifier.height(50.dp))

        TextContainer(text = R.string.description_chad)

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            MyButton(onClick = { }, text = R.string.previous_btn)
            MyButton(onClick = { }, text = R.string.next_btn)
        }
    }
}

@Composable
fun ImageContainer(@DrawableRes picture: Int, contentDescription: String) {
    Box(modifier = Modifier
        .shadow(3.dp, shape = RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(picture),
            contentDescription = contentDescription,
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