package com.example.funnycreaturesapp.data.mappers

import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.ArticleUI

object ArticleUIToArticleInCart {
    fun articleUIToArticleInCart(articleUI: ArticleUI): ArticleInCartModel =
        ArticleInCartModel(
            id = articleUI.id,
            name = articleUI.name,
            price = articleUI.price,
            category = articleUI.category,
            img = articleUI.img,
        )

    fun mapToArticleInCartModelList(list: List<ArticleUI>): List<ArticleInCartModel> =
        list.map { articleUIToArticleInCart(it) }

}