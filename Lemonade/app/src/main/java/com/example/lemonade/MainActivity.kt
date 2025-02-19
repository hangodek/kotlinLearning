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

    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

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
        when (currentStep) {
            1 -> {
                LemonadeStep(
                    drawableResourceId = R.drawable.lemon_tree,
                    labelResourceId = R.string.phase1_description,
                    textLabelResourceId = R.string.phase1_content,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                )
            }
            2 -> {
                LemonadeStep(
                    drawableResourceId = R.drawable.lemon_squeeze,
                    labelResourceId = R.string.phase2_description,
                    textLabelResourceId = R.string.phase2_content,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
            }
            3 -> {
                LemonadeStep(
                    drawableResourceId = R.drawable.lemon_drink,
                    labelResourceId = R.string.phase3_description,
                    textLabelResourceId = R.string.phase3_content,
                    onImageClick = {
                        currentStep = 4
                    }
                )
            }
            4 -> {
                LemonadeStep(
                    drawableResourceId = R.drawable.lemon_restart,
                    labelResourceId = R.string.phase4_description,
                    textLabelResourceId = R.string.phase4_content,
                    onImageClick = {
                        currentStep = 1
                    }
                )
            }
        }

    }
}

@Composable
fun LemonadeStep(drawableResourceId: Int, labelResourceId: Int, textLabelResourceId: Int, onImageClick: () -> Unit, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(drawableResourceId),
        contentDescription = stringResource(labelResourceId),
        modifier = Modifier
            .background(color = Color(0xffc3ecd2), shape = RoundedCornerShape(48.dp))
            .padding(48.dp, 24.dp)
            .clickable {
                onImageClick()
            }
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = stringResource(textLabelResourceId)
    )
}
