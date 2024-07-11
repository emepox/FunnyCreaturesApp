package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.data.DataSourceImpl

@Composable
fun Articles(
    articles: List<Article>,
    modifier: Modifier = Modifier,
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.smallestScreenWidthDp
    val screenHeight = configuration.screenHeightDp

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.height(screenHeight.dp)
        //columns = GridCells.Adaptive((screenWidth / 2).dp)
    ) {
        items(
            count = articles.size,
        ) { itemIndex ->
            ArticleCard(item = articles[itemIndex])
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleCard(
    item: Article,
) {
    Card(
        onClick = { /*TODO*/ },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .height(230.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(5.dp)
        ) {
            Column {
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Cyan)
                        .height(150.dp)
                ) {
                    // TODO Image
                    Image(
                        painter = painterResource(
                            id = if (item.isFavourite) R.drawable.baseline_favorite else R.drawable.baseline_favorite_empty
                        ),
                        contentDescription = "Is favourite",
                    )
                }

            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item.price.toString() + "€",
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_grade),
                            contentDescription = "Rating"
                        )
                        Text(
                            text = item.rating.toString(),
                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun ArticlesPreview() {
    Articles(articles = DataSourceImpl.articles)
}

@Preview
@Composable
fun ArticlePreview() {
    ArticleCard(item = DataSourceImpl.articles[0])
}

