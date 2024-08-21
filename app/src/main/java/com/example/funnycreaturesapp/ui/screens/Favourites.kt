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
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.ui.common.Articles

@Composable
fun Favourites(
    favouriteArticles: List<ArticleUI>,
    onItemClicked: () -> Unit,
    onFavouriteClicked: (ArticleUI) -> Unit,
    modifier: Modifier = Modifier
) {
    if(favouriteArticles.isEmpty()) {
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
        onItemClicked = { onItemClicked() },
        favouriteArticles = favouriteArticles,
        onFavouriteClicked = onFavouriteClicked,
    )
}