package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.models.DataSourceArticle
import com.example.funnycreaturesapp.models.DataSourceArticle.*

interface DataSource {
    val dataSourceArticles: List<DataSourceArticle>
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