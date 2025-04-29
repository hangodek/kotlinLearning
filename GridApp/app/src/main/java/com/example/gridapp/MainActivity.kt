package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridapp.data.DataSource
import com.example.gridapp.model.Topic
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridAppTheme {
                Surface {
                    
                }
            }
        }
    }
}

@Composable
fun GridApp() {
    GridList(topicList = DataSource.loadTopics())
}

@Composable
fun GridList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(topicList) { topic ->
            GridCard(topic = topic, modifier = Modifier.padding(8.dp))
        }
    }
}


@Composable
fun GridCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card {
        Row {
            Image(
                painter = painterResource(topic.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 85.dp, height = 85.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .width(150.dp)
            ) {
                Text(
                    text = stringResource(topic.name),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.bodyLarge
                )
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.cozyicon),
                        contentDescription = null,
                        modifier = Modifier.width(16.dp)
                    )
                    Text(
                        text = "${topic.availableCourses} courses",
                        fontSize = 8.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridApp()
}