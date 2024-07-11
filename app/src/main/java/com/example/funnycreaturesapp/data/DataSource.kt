package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.data.Article.Type

object DataSource {
    val articles: List<Article> = listOf(
        Article(
            name = "Manos de topo",
            type = Type.FOOD,
            price = 200,
        ),
        Article(
            name = "Cabeza de dragón",
            type = Type.PART,
            price = 3300,
        ),
        Article(
            name = "Hominino",
            type = Type.MONSTER,
            price = 33000,
        )
    )

}


data class Article(
    val name: String,
    val type: Type,
    val price: Int,
) {
    enum class Type {
        MONSTER, FOOD, PART
    }
}