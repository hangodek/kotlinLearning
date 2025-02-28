package com.example.thirtydaysroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.thirtydaysroutines.datasource.RoutinesRepository.routines

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {

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
                dayDescription = routine.dayDescription
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
    Card {
        Column {
            Text(
                text = stringResource(day)
            )
            Text(
                text = stringResource(dayHeader)
            )
            Image(
                painter = painterResource(dayImage),
                contentDescription = null
            )
            Text(
                text = stringResource(dayDescription)
            )
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
