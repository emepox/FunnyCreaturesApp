package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.ui.common.Articles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    articles: List<Article>,
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
        Articles(articles = articles.filter { it.name == query },
            onItemClicked = { onItemClicked() }
        )
    }
}