package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.ArticleUI
import com.example.funnycreaturesapp.models.Category
import com.example.funnycreaturesapp.models.Category.*
import com.example.funnycreaturesapp.models.DataSourceArticle

object DataSamples {
    val sampleOfUIArticles = listOf(
        ArticleUI(
            id = "123",
            name = "Hominino",
            category = MONSTER,
            price = 200.00,
            rating = "3.5",
            img = "hominino",
            description = "Lorem Ipsum dolor",
            isInOffer = false,
        ),
        ArticleUI(
            id = "234",
            name = "Draconino",
            category = MONSTER,
            price = 200.00,
            rating = "3.5",
            img = "dragonino",
            description = "Lorem Ipsum dolor",
            isInOffer = false,
        ),
        ArticleUI(
            id = "123",
            name = "Hominino",
            category = MONSTER,
            price = 200.00,
            rating = "3.5",
            img = "hominino",
            description = "Lorem Ipsum dolor",
            isInOffer = false,
        )
    )

    val sampleOfCartArticles = listOf(
        ArticleInCartModel(
            id = "123",
            name = "Hominino",
            price = 200.00,
            category = MONSTER,
            img = "hominino",
            amount = 2,
        ),
        ArticleInCartModel(
            id = "234",
            name = "Draconino",
            category = MONSTER,
            price = 200.00,
            img = "draconino",
            amount = 1,
        ),
    )

}