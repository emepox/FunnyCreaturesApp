package com.example.funnycreaturesapp.utils

import com.example.funnycreaturesapp.data.listOfAds
import com.example.funnycreaturesapp.data.listOfUrlImages

object RemoteImageUploader {

    fun uploadRemoteImage(partialUrl: String): String {
        return assignUrlToImage(partialUrl)
    }

    private fun assignUrlToImage(partialUrl: String): String =
        URL_PREFIX + (getRandomImage(partialUrl) ?: NO_IMAGE_PLACEHOLDER) + EXTENSION

    private fun getRandomImage(partialUrl: String): String? {
        return if (partialUrl.contains("ad_")) {
            listOfAds.filter { it.contains(partialUrl) }.randomOrNull()
        } else {
            listOfUrlImages.filter { it.contains(partialUrl) }.randomOrNull()
        }
    }
}

private const val EXTENSION = ".png"
private const val NO_IMAGE_PLACEHOLDER = "image_placeholder"
private const val URL_PREFIX =
    "https://raw.githubusercontent.com/emepox/emepox.github.io/master/assets/"