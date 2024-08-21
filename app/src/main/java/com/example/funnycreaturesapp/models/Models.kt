package com.example.funnycreaturesapp.models

data class DataSourceArticle(
    val name: String,
    val category: Category,
    val price: Double,
    val rating: Double,
    val img: String,
    val description: String,
    val isInOffer: Boolean = false,
)

data class ArticleUI(
    val id: String,
    val name: String,
    val category: Category,
    val price: Double,
    val rating: String,
    val description: String,
    val img: String,
    val isInOffer: Boolean,
)

data class ArticleInCartModel(
    val id: String,
    val name: String,
    val price: Double,
    val category: Category,
    val img: String,
    val amount: Int,
)

enum class Category {
    MONSTER, FOOD, ACCESSORIES,
}