package com.example.funnycreaturesapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.DataSourceArticle
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.ui.common.NavBar
import com.example.funnycreaturesapp.ui.common.TopBar
import com.example.funnycreaturesapp.ui.screens.Article
import com.example.funnycreaturesapp.ui.screens.Favourites
import com.example.funnycreaturesapp.ui.screens.Home
import com.example.funnycreaturesapp.ui.screens.Profile
import com.example.funnycreaturesapp.ui.screens.Search

@Composable
fun FunnyCreaturesApp(
    navController: NavHostController = rememberNavController(),
    ) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FunnyCreaturesAppScreens.valueOf(
        backStackEntry?.destination?.route ?: FunnyCreaturesAppScreens.Home.name
    )
    val repository: List<DataSourceArticle> = DataSourceImpl.dataSourceArticles
    val viewModel: FunnyCreaturesAppViewModel = viewModel(factory = FunnyCreaturesAppViewModel.funnyCreaturesAppViewModelFactory(repository))
    val articles by viewModel.articles.collectAsState()
    val articlesInCart by viewModel.articlesInCart.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() },
                articlesInCart = articlesInCart.size,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        bottomBar = {
            NavBar(
                navController = navController,
                Modifier.padding(top = 5.dp)
            )
        },
        contentWindowInsets = WindowInsets(0.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 40.dp)
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = FunnyCreaturesAppScreens.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = FunnyCreaturesAppScreens.Home.name,
                content = {
                    Home(
                        listOfArticles = articles,
                        onItemClicked = { articleId ->
                            viewModel.selectArticle(articleId)
                            navController.navigate(FunnyCreaturesAppScreens.Article.name)
                        }
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Search.name,
                content = {
                    Search(
                        listOfArticles = articles,
                        onItemClicked = { navController.navigate(FunnyCreaturesAppScreens.Article.name) }
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Favourites.name,
                content = {
                    Favourites(
                        favouriteArticles = articles.filter {
                            it.isFavourite
                        },
                        onItemClicked = { navController.navigate(FunnyCreaturesAppScreens.Article.name) }
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Profile.name,
                content = { Profile() }
            )
            composable(
                route = FunnyCreaturesAppScreens.Article.name,
                content = {
                    val selectedArticle by viewModel.selectedArticle.collectAsState()
                    selectedArticle?.let { article ->
                        Article(
                            selectedArticle = article,
                            onAddClicked = { addedArticle, amount ->
                                viewModel.addToCart(addedArticle, amount)
                            }
                        )
                    }
                }
            )
        }
    }
}

enum class FunnyCreaturesAppScreens(@StringRes val title: Int) {
    Home(title = R.string.home),
    Search(title = R.string.search),
    Favourites(title = R.string.favourites),
    Profile(title = R.string.profile),
    Article(title = R.string.article),
}