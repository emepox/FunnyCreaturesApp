package com.example.funnycreaturesapp.data

import androidx.compose.runtime.Composable
import com.example.funnycreaturesapp.data.DataSourceArticle.Category
import com.example.funnycreaturesapp.ui.common.RectangleShape
import com.example.funnycreaturesapp.ui.common.RectangleShapeSize

interface DataSource {
    val dataSourceArticles: List<DataSourceArticle>
}

data class DataSourceArticle(
    val name: String,
    val category: Category,
    val price: Double,
    val rating: Double,
    val description: String = "Lorem Ipsum",
    val img: @Composable () -> Unit,
    val isInOffer: Boolean = false,
) {
    enum class Category {
        MONSTER, FOOD, PART, ACCESSORIES,
    }
}

object DataSourceImpl: DataSource {
    override val dataSourceArticles: List<DataSourceArticle> = listOf(
        DataSourceArticle(
            name = "Manos de topo",
            category = Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
            description = "Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. Mole hands with all their claws and little wrinkles. "
        ),
        DataSourceArticle(
            name = "Cabeza de dragón",
            category = Category.PART,
            price = 200.00,
            rating = 4.8,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },

            ),
        DataSourceArticle(
            name = "Hominino",
            category = Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Manos de topo",
            category = Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Cabeza de dragón",
            category = Category.PART,
            price = 200.00,
            rating = 4.8,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },

            ),
        DataSourceArticle(
            name = "Hominino",
            category = Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Manos de topo",
            category = Category.FOOD,
            price = 200.00,
            rating = 4.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Cabeza de dragón",
            category = Category.PART,
            price = 200.00,
            rating = 4.8,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },

            ),
        DataSourceArticle(
            name = "Hominino",
            category = Category.MONSTER,
            price = 200.00,
            rating = 3.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        DataSourceArticle(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 200.00,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        )


    )

}