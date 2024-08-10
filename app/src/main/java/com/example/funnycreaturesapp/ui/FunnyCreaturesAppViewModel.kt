package com.example.funnycreaturesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.data.DataSamples
import com.example.funnycreaturesapp.data.mappers.ArticleUIToArticleInCart
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
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

    init {
        // Call the articles repository. Assign it to the _articles variable.
        _articles.value = DataSourceArticleToUiArticle.mapToUiModelList(repository)
        _articlesInCart.value = DataSamples.sampleOfCartArticles
    }

    fun addToCart(articleUI: ArticleUI, amount: Int) {
        val mappedArticle = ArticleUIToArticleInCart.articleUIToArticleInCart(articleUI)
        repeat(amount) {
            _articlesInCart.value += mappedArticle
        }
    }

    fun selectArticle(articleId: String) {
        _selectedArticle.value = _articles.value.find { it.id == articleId }
    }

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