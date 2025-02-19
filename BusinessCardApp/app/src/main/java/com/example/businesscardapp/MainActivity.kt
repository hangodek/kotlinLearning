package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface() {
                    Column(modifier = Modifier
                        .fillMaxSize(), verticalArrangement = Arrangement.Center) {
                        Spacer(modifier = Modifier.weight(2f))
                        MiddleSection()
                        Spacer(modifier = Modifier.weight(1f))
                        BottomSection()
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun MiddleSection(modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.logo)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = logo,
            contentDescription = null
        )
        Text(
            text = "Muhammad Farhan Pulungan",
            fontSize = 36.sp,
            fontWeight = Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Full-Stack Developer",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun BottomSection(modifier: Modifier = Modifier) {
    val mail = painterResource(R.drawable.mail)
    val phone = painterResource(R.drawable.phone)

    Row(modifier = Modifier
        .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            painter = mail,
            contentDescription = null
        )
        Text(
            text = "icyfarhan@gmail.com"
        )
    }
    Row(modifier = Modifier
        .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            painter = phone,
            contentDescription = null,
        )
        Text(
            text = "+6281375255800"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Column(modifier = Modifier
            .fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(2f))
            MiddleSection()
            Spacer(modifier = Modifier.weight(1f))
            BottomSection()
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}