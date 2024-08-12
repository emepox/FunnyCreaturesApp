package com.example.funnycreaturesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.data.mappers.ListOfArticlesToCartModel
import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.models.DataSourceArticle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FunnyCreaturesAppViewModel(repository: List<DataSourceArticle>) : ViewModel() {

    private var _articles = MutableStateFlow<List<ArticleUI>>(emptyList())
    val articles: StateFlow<List<ArticleUI>> = _articles.asStateFlow()

    private var _articlesInCart = MutableStateFlow<List<ArticleInCartModel>>(emptyList())
    val articlesInCart: StateFlow<List<ArticleInCartModel>> = _articlesInCart.asStateFlow()

    private var _selectedArticle = MutableStateFlow<ArticleUI?>(null)
    val selectedArticle: StateFlow<ArticleUI?> = _selectedArticle.asStateFlow()

    private var _favouriteArticles = MutableStateFlow<List<ArticleUI>>(emptyList())
    val favouriteArticles = _favouriteArticles.asStateFlow()

    private var _cartArticlesAmount = MutableStateFlow(0)
    val cartArticlesAmount = _cartArticlesAmount.asStateFlow()

    init {
        _articles.value = DataSourceArticleToUiArticle.mapToUiModelList(repository)
    }


    // Home screen
    fun selectArticle(articleId: String) {
        _selectedArticle.value = _articles.value.find { it.id == articleId }
    }

    // Cart

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
    }

    fun increaseArticle(article: ArticleInCartModel) {
        val updatedArticles = _articlesInCart.value.map {
            if (it.id == article.id) {
                it.copy(amount = it.amount.plus(1))
            }
            else {
                it
            }
        }
        _articlesInCart.value = updatedArticles
        checkCartArticlesAmount()
    }

    fun reduceArticle(article: ArticleInCartModel) {
        val updatedArticles = _articlesInCart.value.map {
            if (it.id == article.id) {
                it.copy(amount = it.amount.decreaseSafely())
            }
            else {
                it
            }
        }
        _articlesInCart.value = updatedArticles
        checkCartArticlesAmount()
    }

    private fun Int.decreaseSafely(): Int {
        return if (this > 1) this - 1 else this
    }

    fun removeArticle(article: ArticleInCartModel) {
        _articlesInCart.value -= article
        checkCartArticlesAmount()
    }

    fun cleanCart() {
        _articlesInCart.value = emptyList()
        checkCartArticlesAmount()
    }

    private fun checkIfArticleIsInCart(id: String): Boolean =
        _articlesInCart.value.any { it.id == id}

    private fun checkCartArticlesAmount() {
        val total = _articlesInCart.value.sumOf { it.amount }
        _cartArticlesAmount.value = total
    }


    // Favourites
    fun onClickedFavourite(article: ArticleUI) {
        if (favouriteArticles.value.contains(article)) {
            removeFromFavourites(article)
        } else {
            addToFavourites(article)
        }
    }

    private fun addToFavourites(article: ArticleUI) {
        _favouriteArticles.value += article
    }

    private fun removeFromFavourites(article: ArticleUI) {
        _favouriteArticles.value -= article
    }

    companion object {
        fun funnyCreaturesAppViewModelFactory(repository: List<DataSourceArticle>): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(FunnyCreaturesAppViewModel::class.java)) {
                        return FunnyCreaturesAppViewModel(repository) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }

}