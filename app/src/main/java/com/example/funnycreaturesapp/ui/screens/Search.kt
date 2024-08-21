package com.example.funnycreaturesapp.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.ui.common.Articles
import com.example.funnycreaturesapp.ui.viewModels.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    listOfArticles: List<ArticleUI>,
    onItemClicked: () -> Unit,
    onFavouriteClicked: (ArticleUI) -> Unit,
    favouritesList: List<ArticleUI>,
    modifier: Modifier = Modifier,
) {
    val viewModel: SearchViewModel =
        viewModel(factory = SearchViewModel.searchViewModelFactory(listOfArticles))

    var query by remember { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = {
                    viewModel.resetFilters()
                    query = it
                },
                expanded = true,
                onExpandedChange = { expanded = it },
                onSearch = { viewModel.filterArticlesByQuery(query) },
                placeholder = { Text(text = stringResource(id = R.string.type)) },
            )
        },
        expanded = true,
        onExpandedChange = { expanded = it},
    ) {
        Articles(
            articles = viewModel.filterArticlesWhileTyping(query),
            onItemClicked = { onItemClicked() },
            onFavouriteClicked = onFavouriteClicked,
            favouriteArticles = favouritesList,
        )
    }
}