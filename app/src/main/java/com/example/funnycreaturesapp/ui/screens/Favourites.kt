package com.example.funnycreaturesapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.ui.common.Articles

@Composable
fun Favourites(
    favouriteArticles: List<ArticleUI>,
    onItemClicked: () -> Unit,
    onFavouriteClicked: (ArticleUI) -> Unit,
    modifier: Modifier = Modifier
) {
    Articles(
        articles = favouriteArticles,
        onItemClicked = { onItemClicked() },
        favouriteArticles = favouriteArticles,
        onFavouriteClicked = onFavouriteClicked,
    )
}