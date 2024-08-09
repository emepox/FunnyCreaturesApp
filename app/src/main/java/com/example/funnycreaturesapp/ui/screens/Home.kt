package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.ui.common.Ad
import com.example.funnycreaturesapp.ui.common.Articles
import com.example.funnycreaturesapp.ui.common.Categories
import com.example.funnycreaturesapp.ui.theme.FunnyCreaturesAppTheme
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI
import com.example.funnycreaturesapp.ui.viewModels.HomeViewModel

@Composable
fun Home(
    listOfArticles: List<ArticleUI>,
    onItemClicked: (String) -> Unit,
    onAdClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val viewModel: HomeViewModel =
        viewModel(factory = HomeViewModel.homeViewModelFactory(listOfArticles))
    val articles by viewModel.articles.collectAsState()

    Column(
        modifier = modifier.verticalScroll(
            state = ScrollState(rememberScrollState().value)
        )
    ) {

        viewModel.advertisement?.let {
            Ad(
                ad = it,
                onAddClicked = { articleInOffer ->
                    onAdClicked(articleInOffer)
                }
            )
        }
        Categories(
            onCategoryClicked = { category ->
                viewModel.filteredArticlesByCategory(category)
            },
            onSeeAllClicked = { viewModel.resetArticlesFilter() }
        )
        Articles(
            articles = articles,
            onItemClicked = { articleId ->
                onItemClicked(articleId)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunnyCreaturesAppTheme {
        Home(
            DataSourceArticleToUiArticle.mapToUiModelList(
                DataSourceImpl.dataSourceArticles),
            {},{}
        )
    }
}