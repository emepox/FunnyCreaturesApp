package com.example.funnycreaturesapp.ui

import android.app.Application
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.models.DataSourceArticle
import com.example.funnycreaturesapp.ui.common.NavBar
import com.example.funnycreaturesapp.ui.common.TopBar
import com.example.funnycreaturesapp.ui.screens.Article
import com.example.funnycreaturesapp.ui.screens.Cart
import com.example.funnycreaturesapp.ui.screens.Favourites
import com.example.funnycreaturesapp.ui.screens.Home
import com.example.funnycreaturesapp.ui.screens.LogIn
import com.example.funnycreaturesapp.ui.screens.Profile
import com.example.funnycreaturesapp.ui.screens.Search
import com.example.funnycreaturesapp.ui.screens.SignUp
import com.example.funnycreaturesapp.ui.viewModels.UserSettingsViewModel

@Composable
fun FunnyCreaturesApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FunnyCreaturesAppScreens.valueOf(
        backStackEntry?.destination?.route ?: FunnyCreaturesAppScreens.Home.name
    )
    val context = LocalContext.current
    val application = context.applicationContext as Application
    // Data
    val sourceArticles: List<DataSourceArticle> = DataSourceImpl.dataSourceArticles
    val viewModel: FunnyCreaturesAppViewModel =
        viewModel(factory = FunnyCreaturesAppViewModel.funnyCreaturesAppViewModelFactory(sourceArticles, application))
    // User settings
    val isSessionActive by viewModel.isSessionActive.collectAsState()
    val userSettingsViewModel: UserSettingsViewModel =
        viewModel(factory = UserSettingsViewModel.userCredentialsViewModelFactory(application))
    // Articles
    val articles by viewModel.articles.collectAsState()
    val articlesInCart by viewModel.articlesInCart.collectAsState()
    val numberOfArticlesInCart by viewModel.cartArticlesAmount.collectAsState()
    // Favourites
    val favouriteArticles by viewModel.favouriteArticles.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() },
                articlesInCart = numberOfArticlesInCart,
                onCartClicked = {
                    navController.navigate(FunnyCreaturesAppScreens.Cart.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        bottomBar = {
            NavBar(
                navController = navController,
                activeSession = isSessionActive,
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
                content = { backStackEntry ->
                    Home(
                        listOfArticles = articles,
                        onItemClicked = { articleId ->
                            viewModel.selectArticle(articleId)
                            navController.navigate(FunnyCreaturesAppScreens.Article.name)
                        },
                        onAdClicked = { articleInOffer ->
                            navController.navigate(FunnyCreaturesAppScreens.Search.name)
                        },
                        onFavouriteClicked = { article ->
                            viewModel.onClickedFavourite(article)
                        },
                        favouriteArticles = favouriteArticles,
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Search.name,
                content = {
                    Search(
                        listOfArticles = articles,
                        onItemClicked = { navController.navigate(FunnyCreaturesAppScreens.Article.name) },
                        onFavouriteClicked = { article ->
                            viewModel.onClickedFavourite(article)
                        },
                        favouritesList = favouriteArticles,
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Favourites.name,
                content = {
                    Favourites(
                        favouriteArticles = favouriteArticles,
                        onItemClicked = { navController.navigate(FunnyCreaturesAppScreens.Article.name) },
                        onFavouriteClicked = { article ->
                            viewModel.onClickedFavourite(article)
                        }
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Profile.name,
                content = {
                    Profile(
                        onLogOutClicked = {
                            viewModel.logOut()
                            navController.navigate(FunnyCreaturesAppScreens.Home.name)
                        },
                        viewModel = userSettingsViewModel,
                        isSessionActive = isSessionActive,
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Article.name,
                content = {
                    val selectedArticle by viewModel.selectedArticle.collectAsState()
                    selectedArticle?.let { article ->
                        Article(
                            selectedArticle = article,
                            onAddClicked = { addedArticle, amount ->
                                viewModel.addArticleToCart(addedArticle, amount)
                            },
                            isFavourite = (favouriteArticles.contains(selectedArticle)),
                            onFavouriteClicked = { favouritedArticle ->
                                viewModel.onClickedFavourite(favouritedArticle)
                            },
                        )
                    }
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.Cart.name,
                content = {
                    Cart(
                        listOfArticlesInCart = articlesInCart,
                        onIncreaseUnitClicked = { article ->
                            viewModel.increaseArticle(article)
                        },
                        onDecreaseUnitClicked = { article ->
                            viewModel.reduceArticle(article)
                        },
                        onRemoveArticleClicked = { article ->
                            viewModel.removeArticle(article)
                        },
                        onCheckoutClicked = {
                            if (articlesInCart.isNotEmpty()) {
                                viewModel.cleanCart()
                                navController.navigate(FunnyCreaturesAppScreens.ThankYou.name)
                            }
                        },
                        onGoBackButtonClicked = {
                            navController.navigateUp()
                        }
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.ThankYou.name,
                content = {
                    Text(
                        text = stringResource(id = R.string.thank_you_message),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.LogIn.name,
                content = {
                    LogIn(
                        onCreateAccountClicked = {
                            navController.navigate(FunnyCreaturesAppScreens.SignUp.name)
                        },
                        viewModel = userSettingsViewModel,
                        onLogInSuccessful = {
                            viewModel.logIn()
                            navController.navigate(FunnyCreaturesAppScreens.Profile.name)
                        }
                    )
                }
            )
            composable(
                route = FunnyCreaturesAppScreens.SignUp.name,
                content = {
                    SignUp(
                        viewModel = userSettingsViewModel,
                        onAccountCreated = {
                            navController.navigate(FunnyCreaturesAppScreens.LogIn.name)
                        }
                    )
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
    Cart(title = R.string.cart),
    ThankYou(title = R.string.thank_you),
    LogIn(title = R.string.log_in),
    SignUp(title = R.string.sign_up),
}