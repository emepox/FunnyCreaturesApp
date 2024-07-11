package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.data.DataSourceImpl

@OptIn(ExperimentalMaterial3Api::class)
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
            Card(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
                modifier = Modifier.height(200.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ArticleImgPlaceholder(
                        text = "Img",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(fraction = 0.9f)

                    )
                    Text(
                        text = articles[itemIndex].name,
                    )

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

