package com.example.funnycreaturesapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.ui.common.NavBar
import com.example.funnycreaturesapp.ui.common.TopBar
import com.example.funnycreaturesapp.ui.screens.Favourites
import com.example.funnycreaturesapp.ui.screens.Home
import com.example.funnycreaturesapp.ui.screens.Profile
import com.example.funnycreaturesapp.ui.screens.Search

@Composable
fun FunnyCreaturesApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FunnyCreaturesAppScreens.valueOf(
        backStackEntry?.destination?.route ?: FunnyCreaturesAppScreens.Home.name
    )
    val articles = DataSourceImpl.articles

    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
            )
        },
        bottomBar = {
            NavBar(
                navController = navController,
                Modifier
                    .background(Color.Cyan)
            )
        },
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
                content = { Home(
                    articles = articles
                ) }
            )
            composable(
                route = FunnyCreaturesAppScreens.Search.name,
                content = { Search() }
            )
            composable(
                route = FunnyCreaturesAppScreens.Favourites.name,
                content = { Favourites(
                    favouriteArticles = articles.filter {
                        it.isFavourite
                    }
                ) }
            )
            composable(
                route = FunnyCreaturesAppScreens.Profile.name,
                content = { Profile() }
            )
        }
    }
}

enum class FunnyCreaturesAppScreens(@StringRes val title: Int) {
    Home(title = R.string.home),
    Search(title = R.string.search),
    Favourites(title = R.string.favourites),
    Profile(title = R.string.profile),
}