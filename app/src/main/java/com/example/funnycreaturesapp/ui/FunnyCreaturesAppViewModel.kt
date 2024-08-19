package com.example.funnycreaturesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.data.mappers.ListOfArticlesToCartModel
import com.example.funnycreaturesapp.db.dataStore.SessionManager
import com.example.funnycreaturesapp.db.room.AppDatabase
import com.example.funnycreaturesapp.db.room.UserRepository
import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.models.DataSourceArticle
import com.example.funnycreaturesapp.models.UserSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FunnyCreaturesAppViewModel(
    repository: List<DataSourceArticle>,
    application: Application
) : AndroidViewModel(application = application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()
    private val userRepository = UserRepository(userDao)
    private val sessionManager = SessionManager(application.applicationContext)

    // USER SETTINGS
    private var _activeUser = MutableStateFlow<UserSettings?>(UserSettings())
    val activeUser = _activeUser.asStateFlow()
    private var _isSessionActive = MutableStateFlow(false)
    val isSessionActive = _isSessionActive.asStateFlow()

    // ARTICLES
    private var _articles = MutableStateFlow<List<ArticleUI>>(emptyList())
    val articles: StateFlow<List<ArticleUI>> = _articles.asStateFlow()
    private var _selectedArticle = MutableStateFlow<ArticleUI?>(null)
    val selectedArticle: StateFlow<ArticleUI?> = _selectedArticle.asStateFlow()

    // FAVOURITES
    private var _favouriteArticles = MutableStateFlow<List<ArticleUI>>(emptyList())
    val favouriteArticles = _favouriteArticles.asStateFlow()

    // CART
    private var _articlesInCart = MutableStateFlow<List<ArticleInCartModel>>(emptyList())
    val articlesInCart: StateFlow<List<ArticleInCartModel>> = _articlesInCart.asStateFlow()
    private var _cartArticlesAmount = MutableStateFlow(0)
    val cartArticlesAmount = _cartArticlesAmount.asStateFlow()

    init {
        _articles.value = DataSourceArticleToUiArticle.mapToUiModelList(repository)
        // On start, check if there's an active session
        checkActiveSession()

    }

    // HOME
    fun selectArticle(articleId: String) {
        _selectedArticle.value = _articles.value.find { it.id == articleId }
    }

    // CART
    fun addArticleToCart(article: ArticleUI, amount: Int = 1) {
        val cartArticleModel = ListOfArticlesToCartModel.articleToCartArticle(article)
        // Check if element if in the list
        if (checkIfArticleIsInCart(cartArticleModel.id)) {
            // If it is, increase amount
            val updatedArticles = _articlesInCart.value.map {
                if (it.id == cartArticleModel.id) {
                    it.copy(amount = it.amount.plus(amount))
                } else it
            }
            _articlesInCart.value = updatedArticles
        } else {
            // If it isn't, add article to list
            _articlesInCart.value += cartArticleModel
        }
        checkCartArticlesAmount()
        onCartChanges(_articlesInCart.value)

    }

    fun increaseArticle(article: ArticleInCartModel) {
        val updatedArticles = _articlesInCart.value.map {
            if (it.id == article.id) {
                it.copy(amount = it.amount.plus(1))
            } else {
                it
            }
        }
        _articlesInCart.value = updatedArticles
        onCartChanges(_articlesInCart.value)
        checkCartArticlesAmount()
    }

    fun reduceArticle(article: ArticleInCartModel) {
        val updatedArticles = _articlesInCart.value.map {
            if (it.id == article.id) {
                it.copy(amount = it.amount.decreaseSafely())
            } else {
                it
            }
        }
        _articlesInCart.value = updatedArticles
        onCartChanges(_articlesInCart.value)
        checkCartArticlesAmount()
    }

    fun removeArticle(article: ArticleInCartModel) {
        _articlesInCart.value -= article
        onCartChanges(_articlesInCart.value)
        checkCartArticlesAmount()
    }

    fun cleanCart() {
        _articlesInCart.value = emptyList()
        onCartChanges(_articlesInCart.value)
        checkCartArticlesAmount()
    }

    private fun checkIfArticleIsInCart(id: String): Boolean =
        _articlesInCart.value.any { it.id == id }

    private fun checkCartArticlesAmount() {
        val total = _articlesInCart.value.sumOf { it.amount }
        _cartArticlesAmount.value = total
    }


    // FAVOURITES
    fun onClickedFavourite(article: ArticleUI) {
        if (favouriteArticles.value.contains(article)) {
            removeFromFavourites(article)
        } else {
            addToFavourites(article)
        }
        onFavouritesChanges(_favouriteArticles.value)
    }

    private fun addToFavourites(article: ArticleUI) {
        _favouriteArticles.value += article
        onFavouritesChanges(_favouriteArticles.value)
    }

    private fun removeFromFavourites(article: ArticleUI) {
        _favouriteArticles.value -= article
        onFavouritesChanges(_favouriteArticles.value)

    }

    private fun clearFavourites() {
        _favouriteArticles.value = emptyList()
        onFavouritesChanges(_favouriteArticles.value)
    }

    // USER
    private suspend fun getActiveUser(): UserSettings? =
        sessionManager.userSession.firstOrNull()?.let { id ->
            userRepository.getUserById(id)
        }

    private fun checkActiveSession() {
        viewModelScope.launch {
            // Check if there's an active session
            sessionManager.userSession
                .map { id -> id != null } // If there's a not-null ID, there's an active session
                .distinctUntilChanged()
                .collect { isActive -> // Result of the checking
                    _isSessionActive.value = isActive // Assign value to variable
                    if (isActive) {
                        val user = getActiveUser()
                        _activeUser.value = user // Get the user and synchronize data
                        syncUserData()
                    }
                }
        }
    }

    private fun syncUserData() {
        _activeUser.value?.let { user ->
            _articlesInCart.value = user.cart
            _favouriteArticles.value = user.favourites
        }
        checkCartArticlesAmount()
    }

    private fun onFavouritesChanges(list: List<ArticleUI>) {
        viewModelScope.launch {
            updateDatabaseFavouritesList(list)
        }
    }

    private fun onCartChanges(list: List<ArticleInCartModel>) {
        viewModelScope.launch {
            updateDatabaseCartList(list)
        }
    }

    private suspend fun updateDatabaseCartList(list: List<ArticleInCartModel>) {
        if (_isSessionActive.value) {
            activeUser.value?.let { user ->
                userRepository.updateCart(user.id, list)
            }
        }
    }


    private suspend fun updateDatabaseFavouritesList(list: List<ArticleUI>) {
        if (_isSessionActive.value) {
            activeUser.value?.let { user ->
                userRepository.updateFavourites(user.id, list)
            }
        }
    }


    fun logOut() {
        _isSessionActive.value = false
        cleanCart()
        clearFavourites()
    }

    fun logIn() {
        _isSessionActive.value = true
        viewModelScope.launch {
            val user = getActiveUser()
            _activeUser.value = user
            syncUserData()
        }
        checkCartArticlesAmount()
    }

    companion object {
        fun funnyCreaturesAppViewModelFactory(
            repository: List<DataSourceArticle>,
            application: Application
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(FunnyCreaturesAppViewModel::class.java)) {
                        return FunnyCreaturesAppViewModel(repository, application) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }

        private fun Int.decreaseSafely(): Int {
            return if (this > 1) this - 1 else this
        }
    }

}