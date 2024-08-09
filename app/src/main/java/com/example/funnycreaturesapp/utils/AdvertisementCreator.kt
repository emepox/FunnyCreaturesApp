package com.example.funnycreaturesapp.utils

import com.example.funnycreaturesapp.data.listOfAds
import com.example.funnycreaturesapp.utils.RemoteImageUploader.uploadRemoteImage
import kotlin.random.Random

class AdvertisementCreator {
    object RandomAdvertisementCreator {

        val advertisement = createAdvertisement()

        private fun createAdvertisement(): Advertisement {
            val partialUrl = getRandomAdvertFromList()
            return Advertisement(
                article = extractName(partialUrl),
                articleImage = uploadRemoteImage(partialUrl),
                discount = Random.nextInt(1,95),
            )
        }

        private fun extractName(partialUrl: String): String {
            val name = partialUrl
                .replace("ad_", "")
                .replace(
                    Regex("_\\d+"), " "
                ).replaceFirstChar { it.uppercaseChar() }
            return name
        }

        private fun getRandomAdvertFromList(): String = listOfAds.random()
    }

    data class Advertisement(
        val article: String,
        val articleImage: String,
        val discount: Int,
    )
}
