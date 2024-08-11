package com.example.funnycreaturesapp.data.mappers

import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.ArticleUI

object ListOfArticlesToCartModel {

    fun articleToCartArticle(article: ArticleUI): ArticleInCartModel =
        ArticleInCartModel(
            id = article.id,
            name = article.name,
            price = article.price,
            category = article.category,
            img = article.img,
            amount = 1,
        )
}