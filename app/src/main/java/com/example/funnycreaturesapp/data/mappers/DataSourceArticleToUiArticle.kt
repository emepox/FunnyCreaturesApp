package com.example.funnycreaturesapp.data.mappers

import com.example.funnycreaturesapp.models.Article
import com.example.funnycreaturesapp.models.DataSourceArticle
import com.example.funnycreaturesapp.utils.RemoteImageUploader.uploadRemoteImage
import java.util.UUID

object DataSourceArticleToUiArticle {

    fun mapToUiModel(dataSourceArticle: DataSourceArticle): Article {
        return Article(
            id = UUID.randomUUID().toString(),
            name = dataSourceArticle.name,
            category = dataSourceArticle.category,
            price = dataSourceArticle.price,
            rating = dataSourceArticle.rating.toString(),
            description = dataSourceArticle.description,
            img = uploadRemoteImage(dataSourceArticle.img),
            isInOffer = false,
        )
    }

    fun mapToUiModelList(dataSourceArticle: List<DataSourceArticle>): List<Article> =
        dataSourceArticle.map { mapToUiModel(it) }

}