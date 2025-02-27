package com.example.superheroesapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.data.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.AppTheme

@Composable
fun HeroesApp() {
    Scaffold(topBar = {
        HeroesTopBar()
    }) { contentPadding ->
        HeroesList(contentPadding = contentPadding)
    }
}

@Composable
fun HeroesList(contentPadding: PaddingValues, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(contentPadding)
            .padding(16.dp)
    ) {
        items(heroes) { hero ->
            HeroesCard(
                hero.nameRes, hero.descriptionRes, hero.imageRes, modifier = Modifier.padding(
                    dimensionResource(R.dimen.padding_small)
                )
            )
        }
    }
}

@Composable
fun HeroesCard(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Card(elevation = CardDefaults.cardElevation(2.dp), modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.displayLarge,
            )
        }
    )

}

@Preview(showBackground = true)
@Composable
fun HeroesPreview() {
    AppTheme {
        HeroesApp()
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesPreviewDark() {
    AppTheme(darkTheme = true) {
        HeroesApp()
    }
}