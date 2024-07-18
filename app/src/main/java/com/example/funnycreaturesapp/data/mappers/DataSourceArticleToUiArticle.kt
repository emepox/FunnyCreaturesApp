package com.example.funnycreaturesapp.data.mappers

import com.example.funnycreaturesapp.data.DataSourceArticle
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI
import java.util.UUID

object DataSourceArticleToUiArticle {

    fun mapToUiModel(dataSourceArticle: DataSourceArticle): ArticleUI {
        return ArticleUI(
            id = UUID.randomUUID().toString(),
            name = dataSourceArticle.name,
            category = dataSourceArticle.category,
            price = dataSourceArticle.price.toString(),
            rating = dataSourceArticle.rating.toString(),
            description = dataSourceArticle.description,
            img = {},
            isInOffer = false,
            isFavourite = false,
            isInCart = false,
        )
    }

    fun mapToUiModelList(dataSourceArticle: List<DataSourceArticle>): List<ArticleUI> {
        return dataSourceArticle.map { mapToUiModel(it) }
    }

}