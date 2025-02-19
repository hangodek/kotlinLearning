package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun Quadrant(header: String, content: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
    ) {
        Text(
            text = header,
            fontWeight = Bold,
            fontSize = 14.sp
        )
        Text(
            text = content,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFEADDFF))
                        .padding(16.dp)
                        .width(150.dp)
                        .height(380.dp)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Quadrant(
                        header = "Column composable\n",
                        content = "Displays text and follows the recommended Material Design guidelines.\n"
                    )
                }
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFD0BCFF))
                        .padding(16.dp)
                        .width(150.dp)
                        .height(380.dp)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Quadrant(
                        header = "Text composable\n",
                        content = "Creates a composable that lays out and draws a given Painter class object.\n"
                    )
                }
            }
            Row {
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFB69DF8))
                        .padding(16.dp)
                        .width(150.dp)
                        .height(380.dp)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Quadrant(
                        header = "Image composable\n",
                        content = "A layout composable that places its children in a horizontal sequence.\n"
                    )
                }
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFF6EDFF))
                        .padding(16.dp)
                        .width(150.dp)
                        .height(380.dp)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Quadrant(
                        header = "Row composable\n",
                        content = "A layout composable that places its children in a vertical sequence.\n"
                    )
                }
            }
        }
    }
}