package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.models.Article
import com.example.funnycreaturesapp.ui.common.Articles

@Composable
fun Favourites(
    favouriteArticles: List<Article>,
    onItemClicked: (String) -> Unit,
    onFavouriteClicked: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    if (favouriteArticles.isEmpty()) {
        Text(
            text = stringResource(id = R.string.no_favourites),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
    }
    Articles(
        articles = favouriteArticles,
        onItemClicked = { article ->
            onItemClicked(article)
        },
        favouriteArticles = favouriteArticles,
        onFavouriteClicked = onFavouriteClicked,
    )
}