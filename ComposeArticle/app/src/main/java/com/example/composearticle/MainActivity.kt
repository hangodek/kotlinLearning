package com.example.composearticle

import android.R.color.black
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun ContentHeader(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = Bold,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun Content(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(16.dp, 8.dp)
    )
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    var headerImage = painterResource(R.drawable.headerimage)
    Image(
        painter = headerImage,
        contentDescription = null,
        modifier = Modifier
    )
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column {
        Header()
        ContentHeader(
            text = stringResource(R.string.Header)
        )
        Content(
            text = stringResource(R.string.paragraph_1)
        )
        Content(
            text = stringResource(R.string.paragraph_2),

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        MainContent()
    }
}