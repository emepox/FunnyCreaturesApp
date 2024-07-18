package com.example.funnycreaturesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.data.DataSourceArticle
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FunnyCreaturesAppViewModel(repository: List<DataSourceArticle>) : ViewModel() {

    private var _articles = MutableStateFlow<List<ArticleUI>>(emptyList())
    val articles: StateFlow<List<ArticleUI>> = _articles.asStateFlow()

    private var _articlesInCart = MutableStateFlow<List<ArticleUI>>(emptyList())
    val articlesInCart: StateFlow<List<ArticleUI>> = _articlesInCart.asStateFlow()

    private var _selectedArticle = MutableStateFlow<ArticleUI?>(null)
    val selectedArticle: StateFlow<ArticleUI?> = _selectedArticle.asStateFlow()

    init {
        _articles.value = DataSourceArticleToUiArticle.mapToUiModelList(repository)
    }

    fun addToCart(articleUI: ArticleUI) {
        _articlesInCart.value += articleUI
        updateArticleInList(articleUI.copy(isInCart = true))
    }

    fun removeFromCart(articleUI: ArticleUI) {
        _articlesInCart.value -= articleUI
        updateArticleInList(articleUI.copy(isInCart = false))
    }

    fun selectArticle(articleId: String) {
        _selectedArticle.value = _articles.value.find { it.id == articleId }
    }

    private fun updateArticleInList(updatedArticle: ArticleUI) {
        _articles.value = _articles.value.map { article ->
            if(article.id == updatedArticle.id) updatedArticle else article
        }
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