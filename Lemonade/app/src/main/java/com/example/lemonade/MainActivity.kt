package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage()
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()) {

    var clickCount by remember { mutableStateOf(0) }

    val phase2 = (clickCount + 2..3).random()
    val phase3 = (clickCount + 2..3).random()
    val phase4 = (clickCount + 2..3).random()

    val imageResource = when (clickCount) {
        0 -> R.drawable.lemon_tree
        phase2 -> R.drawable.lemon_squeeze
        phase3 -> R.drawable.lemon_drink
        phase4 -> R.drawable.lemon_restart
    }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Lemonade",
            fontWeight = Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .background(color = Color(0xfff9e44c))
                .height(48.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Spacer(modifier = Modifier.height(250.dp))
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            modifier = Modifier
                .background(color = Color(0xffc3ecd2), shape = RoundedCornerShape(48.dp))
                .padding(48.dp, 24.dp)
                .clickable()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.phase1_content)
        )
    }
}
