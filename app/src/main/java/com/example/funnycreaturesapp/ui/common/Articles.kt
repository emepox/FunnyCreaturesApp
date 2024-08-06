package com.example.funnycreaturesapp.ui.common

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
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI

@Composable
fun Articles(
    articles: List<ArticleUI>,
    onItemClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.height(screenHeight.dp)
    ) {
        items(
            count = articles.size,
        ) { itemIndex ->
            ArticleCard(
                item = articles[itemIndex],
                onItemClicked = {
                    onItemClicked(articles[itemIndex].id)
                })
        }
    }
}

@Preview
@Composable
fun ArticlesPreview() {
    Articles(
        articles = DataSourceArticleToUiArticle.mapToUiModelList(DataSourceImpl.dataSourceArticles),
        onItemClicked = {})
}


