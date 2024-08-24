package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel(listOfArticles: List<Article>) : ViewModel() {

    private val _articles = MutableStateFlow(listOfArticles)
    private val articles: StateFlow<List<Article>> = _articles.asStateFlow()

    private val initialListOfArticles = listOfArticles

    fun filterArticlesByQuery(query: String) {
        val lowerCaseQuery = query.lowercase()

        _articles.value = initialListOfArticles.filter {
            val lowerCaseName = it.name.lowercase()
            lowerCaseName.contains(lowerCaseQuery)
        }
    }

    fun filterArticlesWhileTyping(query: String): List<Article> {
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
        fun searchViewModelFactory(listOfArticles: List<Article>): ViewModelProvider.Factory {
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