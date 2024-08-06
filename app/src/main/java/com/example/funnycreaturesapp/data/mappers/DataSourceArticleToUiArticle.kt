package com.example.funnycreaturesapp.data.mappers

import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.DataSourceArticle
import com.example.funnycreaturesapp.data.listOfUrlImages
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI
import java.util.UUID
import kotlin.random.Random

object DataSourceArticleToUiArticle {

    fun mapToUiModel(dataSourceArticle: DataSourceArticle): ArticleUI {
        return ArticleUI(
            id = UUID.randomUUID().toString(),
            name = dataSourceArticle.name,
            category = dataSourceArticle.category,
            price = dataSourceArticle.price.toString(),
            rating = dataSourceArticle.rating.toString(),
            description = dataSourceArticle.description,
            img = assignUrlToImage(dataSourceArticle.img),
            isInOffer = false,
            isFavourite = false,
        )
    }

    fun mapToUiModelList(dataSourceArticle: List<DataSourceArticle>): List<ArticleUI> {
        return dataSourceArticle.map { mapToUiModel(it) }
    }

    private fun assignPicture(partialUrl: String): String {
        val finalUrl = URL_PREFIX +
                partialUrl +
                (randomNumber(partialUrl) ?: NO_IMAGE_PLACEHOLDER) +
                EXTENSION
        return finalUrl
    }

    private fun randomNumber(partialUrl: String): String? {
        val amountOfDrawables = amountOfPicturesByName(partialUrl)
        return if (amountOfDrawables != null) {
            Random.nextInt(0, amountOfDrawables).toString()
        } else null
    }

    private fun amountOfPicturesByName(partialUrl: String): Int? {
        val drawableFolder = R.drawable::class.java.fields
        val count = drawableFolder.count {
            it.name.contains(partialUrl)
        }
        return if (count == 0) null else count

    }

    private const val EXTENSION = ".png"
    private const val NO_IMAGE_PLACEHOLDER = "image_placeholder"
    private const val URL_PREFIX = "https://raw.githubusercontent.com/emepox/emepox.github.io/master/assets/"

    /*
    ---------------------------
     */


    private fun getRandomImage(partialUrl: String): String? =
        listOfUrlImages.filter { it.contains(partialUrl) }.randomOrNull()

    private fun assignUrlToImage(partialUrl: String): String =
        URL_PREFIX + (getRandomImage(partialUrl)?: NO_IMAGE_PLACEHOLDER) + EXTENSION


}