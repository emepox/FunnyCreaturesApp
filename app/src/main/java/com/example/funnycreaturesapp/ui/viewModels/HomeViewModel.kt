package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.Article
import com.example.funnycreaturesapp.models.Category
import com.example.funnycreaturesapp.utils.AdvertisementCreator.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class HomeViewModel(listOfArticles: List<Article>) : ViewModel() {

    private val _articles = MutableStateFlow(listOfArticles)
    val articles: StateFlow<List<Article>> = _articles.asStateFlow()

    private val initialListOfArticles = listOfArticles

    val advertisement = displayAdvertisement()

    fun filteredArticlesByCategory(category: Category) {
        _articles.value = initialListOfArticles.filter {
            it.category == category
        }
    }

    fun resetArticlesFilter() {
        _articles.value = initialListOfArticles
    }

    private fun displayAdvertisement(): Advertisement? {
        val randomBoolean = Random.nextBoolean()
        return if (randomBoolean) RandomAdvertisementCreator.advertisement else null
    }

    companion object {
        fun homeViewModelFactory(listOfArticles: List<Article>): ViewModelProvider.Factory {
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