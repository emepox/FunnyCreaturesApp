package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.ArticleUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel(listOfArticles: List<ArticleUI>) : ViewModel() {

    private val _articles = MutableStateFlow(listOfArticles)
    private val articles: StateFlow<List<ArticleUI>> = _articles.asStateFlow()

    private val initialListOfArticles = listOfArticles

    fun filterArticlesByQuery(query: String) {
        val lowerCaseQuery = query.lowercase()

        _articles.value = initialListOfArticles.filter {
            val lowerCaseName = it.name.lowercase()
            lowerCaseName.contains(lowerCaseQuery)
        }
    }

    fun filterArticlesWhileTyping(query: String): List<ArticleUI> {
        val lowerCaseQuery = query.lowercase()

        return articles.value.filter {
            val lowerCaseName = it.name.lowercase()
            lowerCaseName.contains(lowerCaseQuery)
        }
    }

    fun resetFilters() {
        _articles.value = initialListOfArticles
    }

    companion object {
        fun searchViewModelFactory(listOfArticles: List<ArticleUI>): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
                        return SearchViewModel(listOfArticles) as T
                    } else {
                        throw IllegalArgumentException("Unknown ViewModel class")
                    }
                }
            }
        }
    }
}