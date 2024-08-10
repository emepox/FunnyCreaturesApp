package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.models.DataSourceArticle

object DataSamples {
    val sampleOfDataSourceArticles = listOf(
        DataSourceArticle(
            name = "Alimaña",
            category = DataSourceArticle.Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = "alimaña",
            description = "Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. "
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = DataSourceArticle.Category.PART,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
        ),
        DataSourceArticle(
            name = "Hominino",
            category = DataSourceArticle.Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
        ),
    )

    val sampleOfUIArticles = listOf(
        ArticleUI(
            id = "",
            name = "Hominino",
            category = DataSourceArticle.Category.MONSTER,
            price = "200.00",
            rating = "3.5",
            img = "hominino",
            description = "Lorem Ipsum dolor",
            isInOffer = false,
        ),
        ArticleUI(
            id = "",
            name = "Draconino",
            category = DataSourceArticle.Category.MONSTER,
            price = "200.00",
            rating = "3.5",
            img = "dragonino",
            description = "Lorem Ipsum dolor",
            isInOffer = false,
        ),
        ArticleUI(
            id = "",
            name = "Acuanino",
            category = DataSourceArticle.Category.MONSTER,
            price = "200.00",
            rating = "3.5",
            img = "acuanino",
            description = "Lorem Ipsum dolor",
            isInOffer = false,
        )
    )

    val sampleOfCartArticles = listOf(
        ArticleInCartModel(
            id = "",
            name = "Draconino",
            price = "200",
            category = DataSourceArticle.Category.MONSTER,
            img = "dragonino"
        ),
        ArticleInCartModel(
            id = "",
            name = "Jaula",
            price = "200",
            category = DataSourceArticle.Category.ACCESSORIES,
            img = "jaula"
        ),
        ArticleInCartModel(
            id = "",
            name = "Casquería",
            price = "200",
            category = DataSourceArticle.Category.FOOD,
            img = "entrañas"
        ),
        ArticleInCartModel(
            id = "",
            name = "Casquería",
            price = "200",
            category = DataSourceArticle.Category.FOOD,
            img = "entrañas"
        ),
        ArticleInCartModel(
            id = "",
            name = "Casquería",
            price = "200",
            category = DataSourceArticle.Category.FOOD,
            img = "entrañas"
        )
    )

}