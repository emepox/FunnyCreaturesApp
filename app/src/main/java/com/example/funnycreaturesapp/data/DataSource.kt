package com.example.funnycreaturesapp.data

import com.example.funnycreaturesapp.models.Category.*
import com.example.funnycreaturesapp.models.DataSourceArticle

interface DataSource {
    val dataSourceArticles: List<DataSourceArticle>
}

const val CRITTER_DESCRIPTION =
    "Critters for food; critters parts for the munchies. Chicken legs or mole hands with all their claws and little wrinkles. Appetisers for your monsters."
const val DRAGONINO_DESCRIPTION =
    "Fancy dragons, long dragons, thick dragons, water dragons, fire dragons. All kinds of dragons."
const val HOMININO_DESCRIPTION =
    "Hominid monsters. Yeti, Bigfoot and the likes of them. Furry and warm friends."
const val AVININO_DESCRIPTION =
    "Creatures with wings, feathered monsters. Ideal for hunting and traveling."
const val ENTRAILS_DESCRIPTION =
    "Feed your monsters the best offal. Tripe, lungs, brains, liver. Gory parts, delicious bloody entrails for a proper development of your creatures."
const val CAGE_DESCRIPTION =
    "Keep your monsters contained within sturdy cages. 100% no-escaping guarantee."

object DataSourceFactoryImpl : DataSource {
    override val dataSourceArticles: List<DataSourceArticle>
        get() = generateSequence {
            ProductFactory().randomisedArticle()
        }
            .take(20)
            .toList()
}

object DataSourceImpl : DataSource {
    override val dataSourceArticles: List<DataSourceArticle> = listOf(
        DataSourceArticle(
            name = "Critter",
            category = FOOD,
            price = 200.00,
            rating = 4.5,
            img = "critter",
            description = CRITTER_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = MONSTER,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
            description = DRAGONINO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Hominino",
            category = MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
            description = HOMININO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Entrails",
            category = FOOD,
            price = 200.00,
            rating = 1.5,
            img = "entrails",
            description = ENTRAILS_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Cage",
            category = ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "cage",
            description = CAGE_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Critter",
            category = FOOD,
            price = 200.00,
            rating = 4.5,
            img = "critter",
            description = CRITTER_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = MONSTER,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
            description = DRAGONINO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Hominino",
            category = MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
            description = HOMININO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Cage",
            category = ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "cage",
            description = CAGE_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Critter",
            category = FOOD,
            price = 200.00,
            rating = 1.5,
            img = "critter",
            description = CRITTER_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Cage",
            category = ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "cage",
            description = CAGE_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Critter",
            category = FOOD,
            price = 200.00,
            rating = 4.5,
            img = "critter",
            description = CRITTER_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Dragonino",
            category = MONSTER,
            price = 200.00,
            rating = 4.8,
            img = "dragonino",
            description = DRAGONINO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Hominino",
            category = MONSTER,
            price = 200.00,
            rating = 3.5,
            img = "hominino",
            description = HOMININO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Cage",
            category = ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = "cage",
            description = CAGE_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Critter",
            category = FOOD,
            price = 200.00,
            rating = 1.5,
            img = "critter",
            description = CRITTER_DESCRIPTION,
        ),

        DataSourceArticle(
            name = "Entrails",
            category = FOOD,
            price = 200.00,
            rating = 1.5,
            img = "entrails",
            description = ENTRAILS_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Avinino",
            category = MONSTER,
            price = 200.00,
            rating = 1.5,
            img = "avinino",
            description = AVININO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Avinino",
            category = MONSTER,
            price = 200.00,
            rating = 1.5,
            img = "avinino",
            description = AVININO_DESCRIPTION,
        ),
        DataSourceArticle(
            name = "Avinino",
            category = MONSTER,
            price = 200.00,
            rating = 1.5,
            img = "avinino",
            description = AVININO_DESCRIPTION,
        ),
    )
}