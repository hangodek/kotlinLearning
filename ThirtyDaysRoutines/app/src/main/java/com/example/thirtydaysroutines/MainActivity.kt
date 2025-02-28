package com.example.thirtydaysroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.thirtydaysroutines.datasource.RoutinesRepository.routines

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                DailyRoutineList()
            }
        }
    }
}

@Composable
fun DailyRoutineList(modifier: Modifier = Modifier) {
    LazyColumn {
        items(routines) { routine ->
            DailyRoutineCard(
                day = routine.day,
                dayHeader = routine.dayHeader,
                dayImage = routine.dayImage,
                dayDescription = routine.dayDescription,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun DailyRoutineCard(
    @StringRes day: Int,
    @StringRes dayHeader: Int,
    @DrawableRes dayImage: Int,
    @StringRes dayDescription: Int,
    modifier: Modifier = Modifier
) {

    var descriptionState by remember { mutableStateOf(false) }

    Card(modifier = modifier, onClick = { descriptionState = !descriptionState }) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize(animationSpec = spring()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(day),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(dayHeader),
                style = MaterialTheme.typography.bodyLarge
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(dayImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            if (descriptionState) {
                Text(
                    text = stringResource(dayDescription),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AppTheme {
        DailyRoutineList()
    }
}
