package com.example.funnycreaturesapp.ui.viewModels

import androidx.compose.runtime.Composable
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

    fun onAddToCartClicked() {
        _articleUiState.value = _articleUiState.value.copy(
            isInCart = !_articleUiState.value.isInCart
        )
    }

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
    val id: String = UUID.randomUUID().toString(),
    val name: String = "Article",
    val category: Category = MONSTER,
    val price: String = "0",
    val rating: String = "0",
    val description: String = "",
    val img: @Composable () -> Unit = {},
    val isInOffer: Boolean = false,
    val isFavourite: Boolean = false,
    val isInCart: Boolean = false,
)
