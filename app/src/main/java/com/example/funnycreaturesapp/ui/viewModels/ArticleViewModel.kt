package com.example.funnycreaturesapp.ui.viewModels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.data.DataSourceArticle.Category
import com.example.funnycreaturesapp.data.DataSourceArticle.Category.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

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

data class ArticleUI(
    val id: String,
    val name: String,
    val category: Category,
    val price: String,
    val rating: String,
    val description: String,
    val img: @Composable () -> Unit,
    val isInOffer: Boolean,
    val isFavourite: Boolean,
)
