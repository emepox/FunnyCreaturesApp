package com.example.funnycreaturesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.ArticleInCartModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel(
    listOfArticlesInCart: List<ArticleInCartModel>
) : ViewModel() {

    private var _listOfArticles = MutableStateFlow(listOfArticlesInCart)

    private var _subtotal = MutableStateFlow(0.0)
    val subtotal = _subtotal.asStateFlow()

    private var _shippingCosts = MutableStateFlow(0.0)
    val shippingCosts = _shippingCosts.asStateFlow()

    private var _discount = MutableStateFlow(0.0)
    val discount = _discount.asStateFlow()

    private var _total = MutableStateFlow(0.0)
    val total = _total.asStateFlow()

    init {
        updateTotals()
    }

    fun updateArticles(newList: List<ArticleInCartModel>) {
        _listOfArticles.value = newList
        updateTotals()
    }

    private fun updateTotals() {
        _subtotal.value = _listOfArticles.value.sumOf { it.amount * it.price }
        _discount.value = (_subtotal.value * 25) / 100
        _shippingCosts.value = SHIPPING
        _total.value = _subtotal.value + _shippingCosts.value - _discount.value
    }

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
        const val SHIPPING = 100.00
    }
}