package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.ui.common.Articles

@Composable
fun Favourites(
    favouriteArticles: List<Article>,
    modifier: Modifier = Modifier
) {
    Articles(articles = favouriteArticles)
}