package com.example.funnycreaturesapp.models

import com.example.funnycreaturesapp.models.DataSourceArticle.*

data class DataSourceArticle(
    val name: String,
    val category: Category,
    val price: Double,
    val rating: Double,
    val img: String,
    val description: String = "Lorem Ipsum",
    val isInOffer: Boolean = false,
) {
    enum class Category {
        MONSTER, FOOD, PART, ACCESSORIES,
    }

    enum class Name {
        DRAGONINO, HOMININO, AVININO, ENTRAÑAS, CASQUERÍA, JAULA,
    }
}

data class ArticleUI(
    val id: String,
    val name: String,
    val category: Category,
    val price: String,
    val rating: String,
    val description: String,
    val img: String,
    val isInOffer: Boolean,
)