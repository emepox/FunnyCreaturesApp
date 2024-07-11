package com.example.funnycreaturesapp.data

import androidx.compose.runtime.Composable
import com.example.funnycreaturesapp.data.Article.Category
import com.example.funnycreaturesapp.ui.common.RectangleShape
import com.example.funnycreaturesapp.ui.common.RectangleShapeSize

interface DataSource {
    val articles: List<Article>
}

object DataSourceImpl: DataSource {
    override val articles: List<Article> = listOf(
        Article(
            name = "Manos de topo",
            category = Category.FOOD,
            price = 200,
            rating = 4.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Cabeza de dragón",
            category = Category.PART,
            price = 3300,
            rating = 4.8,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },

            ),
        Article(
            name = "Hominino",
            category = Category.MONSTER,
            price = 33000,
            rating = 3.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 3000,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Manos de topo",
            category = Category.FOOD,
            price = 200,
            rating = 4.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Cabeza de dragón",
            category = Category.PART,
            price = 3300,
            rating = 4.8,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },

            ),
        Article(
            name = "Hominino",
            category = Category.MONSTER,
            price = 33000,
            rating = 3.5,
            isFavourite = true,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 3000,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 3000,
            rating = 1.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Manos de topo",
            category = Category.FOOD,
            price = 200,
            rating = 4.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Cabeza de dragón",
            category = Category.PART,
            price = 3300,
            rating = 4.8,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },

            ),
        Article(
            name = "Hominino",
            category = Category.MONSTER,
            price = 33000,
            rating = 3.5,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        ),
        Article(
            name = "Jaula",
            category = Category.ACCESSORIES,
            price = 3000,
            rating = 1.5,
            isFavourite = true,
            img = { RectangleShape(RectangleShapeSize.BIG, "Article") },
        )


    )

}

data class Article(
    val name: String,
    val category: Category,
    val price: Int,
    val rating: Double,
    val isFavourite: Boolean = false,
    val img: @Composable () -> Unit,
) {
    enum class Category {
        MONSTER, FOOD, PART, ACCESSORIES,
    }
}