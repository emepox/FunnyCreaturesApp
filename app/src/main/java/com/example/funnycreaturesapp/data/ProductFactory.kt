package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.models.Accessories
import com.example.funnycreaturesapp.models.Category
import com.example.funnycreaturesapp.models.DataSourceArticle
import com.example.funnycreaturesapp.models.Food
import com.example.funnycreaturesapp.models.Monsters
import kotlin.random.Random
import com.example.funnycreaturesapp.utils.*

class ProductFactory {

    fun randomisedArticle(): DataSourceArticle {
        val randomCategory = randomCategory()
        val randomName = randomName(randomCategory)

        return DataSourceArticle(
            name = randomName.name.capitaliseFirstChar(),
            category = randomCategory,
            price = Random.nextDouble(100.00, 3000.00).roundDouble(),
            rating = Random.nextDouble(0.0, 10.0).roundDouble(),
            img = randomName.name.lowercase(),
            description = assignDescription(randomName),
            isInOffer = Random.nextBoolean(),
        )
    }

    private fun randomCategory(): Category =
        Category.entries.random()

    private fun randomName(category: Category): Enum<*> =
        when (category) {
            Category.MONSTER -> Monsters.entries.random()
            Category.FOOD -> Food.entries.random()
            Category.ACCESSORIES -> Accessories.entries.random()
        }

    private fun assignDescription(name: Enum<*>): String =
        when(name) {
            is Monsters -> when (name) {
                Monsters.AVININO -> AVININO_DESCRIPTION
                Monsters.DRAGONINO -> DRAGONINO_DESCRIPTION
                Monsters.HOMININO -> HOMININO_DESCRIPTION
            }
            is Food -> when (name) {
                Food.CRITTER -> CRITTER_DESCRIPTION
                Food.ENTRAILS -> ENTRAILS_DESCRIPTION
            }
            is Accessories -> when (name) {
                Accessories.CAGE -> CAGE_DESCRIPTION
            }
            else -> "Unknown item"
        }
}