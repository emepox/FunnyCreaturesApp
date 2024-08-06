package com.example.funnycreaturesapp.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funnycreaturesapp.ui.common.Articles
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI
import com.example.funnycreaturesapp.ui.viewModels.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    listOfArticles: List<ArticleUI>,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: SearchViewModel =
        viewModel(factory = SearchViewModel.searchViewModelFactory(listOfArticles))

    var query by remember { mutableStateOf("") }

    SearchBar(
        query = query,
        onQueryChange = {
            viewModel.resetFilters()
            query = it
        },
        onSearch = { viewModel.filterArticlesByQuery(query) },
        active = true,
        onActiveChange = { viewModel.filterArticlesByQuery(query) },
    ) {
        Articles(
            articles = viewModel.filterArticlesWhileTyping(query),
            onItemClicked = { onItemClicked() }
        )
    }
}