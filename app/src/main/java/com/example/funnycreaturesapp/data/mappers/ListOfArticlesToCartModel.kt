package com.example.funnycreaturesapp.data.mappers

import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.Article

object ListOfArticlesToCartModel {

    fun articleToCartArticle(article: Article): ArticleInCartModel =
        ArticleInCartModel(
            id = article.id,
            name = article.name,
            price = article.price,
            category = article.category,
            img = article.img,
            amount = 1,
        )
}