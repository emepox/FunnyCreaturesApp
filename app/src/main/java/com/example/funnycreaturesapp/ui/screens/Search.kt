package com.example.funnycreaturesapp.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.funnycreaturesapp.ui.common.Articles
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    articles: List<ArticleUI>,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var query by remember { mutableStateOf("") }

    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = {},
        active = true,
        onActiveChange = {},
    ) {
        Articles(articles = articles.filter { it.name.contains(query) },
            onItemClicked = { onItemClicked() }
        )
    }
}