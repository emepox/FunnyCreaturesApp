package com.example.funnycreaturesapp.ui.common

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.ui.FunnyCreaturesAppScreens

@Composable
fun Articles(
    articles: List<Article>,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val context = LocalContext.current
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
            ArticleCard(item = articles[itemIndex], onItemClicked = { onItemClicked() })
        }
    }
}

@Preview
@Composable
fun ArticlesPreview() {
    Articles(articles = DataSourceImpl.articles, onItemClicked = {})
}


