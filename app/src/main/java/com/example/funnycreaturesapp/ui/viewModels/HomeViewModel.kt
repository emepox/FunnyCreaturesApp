package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.data.DataSourceArticle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(listOfArticles: List<ArticleUI>) : ViewModel() {

    private val _articles = MutableStateFlow(listOfArticles)
    val articles: StateFlow<List<ArticleUI>> = _articles.asStateFlow()

    private val initialListOfArticles = listOfArticles

    fun filteredArticlesByCategory(category: DataSourceArticle.Category) {
        _articles.value = initialListOfArticles.filter {
            it.category == category
        }
    }

    fun resetArticlesFilter() {
        _articles.value = initialListOfArticles
    }

    companion object {
        fun homeViewModelFactory(listOfArticles: List<ArticleUI>): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                        return HomeViewModel(listOfArticles) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }
}