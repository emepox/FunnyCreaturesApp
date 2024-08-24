package com.example.funnycreaturesapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserSettings(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "username") val username: String? = null,
    @ColumnInfo(name = "password") val password: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "cart") val cart: List<ArticleInCartModel> = emptyList(),
    @ColumnInfo(name = "favourites") val favourites: List<Article> = emptyList()
)
