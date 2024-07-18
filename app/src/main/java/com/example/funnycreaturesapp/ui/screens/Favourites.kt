package com.example.funnycreaturesapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.funnycreaturesapp.ui.common.Articles
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI

@Composable
fun Favourites(
    favouriteArticles: List<ArticleUI>,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Articles(articles = favouriteArticles, onItemClicked = { onItemClicked() })
}