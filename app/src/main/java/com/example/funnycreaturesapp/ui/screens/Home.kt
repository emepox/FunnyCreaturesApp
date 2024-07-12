package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.ui.common.Articles
import com.example.funnycreaturesapp.ui.common.Categories
import com.example.funnycreaturesapp.ui.common.RectangleShape
import com.example.funnycreaturesapp.ui.common.RectangleShapeSize
import com.example.funnycreaturesapp.ui.theme.FunnyCreaturesAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    articles: List<Article>,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(
            state = ScrollState(rememberScrollState().value)
        )
    ) {

        RectangleShape(
            size = RectangleShapeSize.SMALL,
            text = "Search bar",
            Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        )

        RectangleShape(
            size = RectangleShapeSize.BIG,
            text = "Ad",
            modifier = Modifier.fillMaxWidth()
        )
        Categories(
            onCategoryClicked = {}
        )
        Articles(articles = articles, onItemClicked = { onItemClicked() })

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunnyCreaturesAppTheme {
        Home(DataSourceImpl.articles, {})
    }
}