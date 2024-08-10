package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.ArticleInCartModel

class CartViewModel(
    val listOfArticlesInCart: List<ArticleInCartModel>
): ViewModel() {



    companion object {
        fun cartViewModelFactory(listOfArticlesInCart: List<ArticleInCartModel>): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
                        return CartViewModel(listOfArticlesInCart) as T
                    } else {
                        throw IllegalArgumentException("Unknown ViewModel class")
                    }
                }
            }
        }
    }
}