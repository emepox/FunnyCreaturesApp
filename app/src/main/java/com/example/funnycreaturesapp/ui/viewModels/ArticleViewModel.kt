package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.ArticleUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArticleViewModel(
    article: ArticleUI
) : ViewModel() {

    // UI state
    private var _articleUiState = MutableStateFlow(article)
    val articleUI: StateFlow<ArticleUI> = _articleUiState.asStateFlow()

    companion object {
        fun articleViewModelFactory(uiArticleModel: ArticleUI): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
                        return ArticleViewModel(uiArticleModel) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }
}


