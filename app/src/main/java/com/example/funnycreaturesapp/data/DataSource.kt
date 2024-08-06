package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.data.DataSourceArticle.Category

interface DataSource {
    val dataSourceArticles: List<DataSourceArticle>
}

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
}

object DataSourceImpl : DataSource {
    override val dataSourceArticles: List<DataSourceArticle> = listOf(
        DataSourceArticle(
            name = "Alimaña",
            category = Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = "alimaña",
            description = "Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. "
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = Category.PART,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
        ),
        DataSourceArticle(
            name = "Hominino",
            category = Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
        ),
        DataSourceArticle(
            name = "Entrañas",
            category = Category.FOOD,
            price = 200.00,
            rating = 1.5,
            img = "entrañas",
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "jaula",
        ),
        DataSourceArticle(
            name = "Alimaña",
            category = Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = "alimaña",
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = Category.PART,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
        ),
        DataSourceArticle(
            name = "Hominino",
            category = Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "jaula",
        ),
        DataSourceArticle(
            name = "Alimaña",
            category = Category.FOOD,
            price = 200.00,
            rating = 1.5,
            img = "alimaña",
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "jaula",
        ),
        DataSourceArticle(
            name = "Alimaña",
            category = Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = "alimaña",
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = Category.PART,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
        ),
        DataSourceArticle(
            name = "Hominino",
            category = Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "jaula",
        ),
        DataSourceArticle(
            name = "Alimaña",
            category = Category.FOOD,
            price = 200.00,
            rating = 1.5,
            img = "alimaña",
        ),

        DataSourceArticle(
            name = "Entrañas",
            category = Category.FOOD,
            price = 200.00,
            rating = 1.5,
            img = "entrañas",
        ),
    )
}

val listOfUrlImages = listOf(
    "dragonino_0",
    "dragonino_1",
    "dragonino_2",
    "dragonino_3",
    "dragonino_4",
    "dragonino_5",
    "dragonino_6",
    "dragonino_7",
    "dragonino_8",
    "dragonino_9",
    "alimaña_0",
    "alimaña_1",
    "acuanino_0",
    "avinino_0",
    "avinino_1",
    "avinino_2",
    "avinino_3",
    "hominino_0",
    "hominino_1",
    "jaula_0",
    "jaula_1",
    "jaula_2",
    "entrañas_0",
    "entrañas_1",

    )