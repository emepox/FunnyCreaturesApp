package com.example.funnycreaturesapp.db.room

import androidx.room.TypeConverter
import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    // Favourites
    @TypeConverter
    fun fromArticleUIList(value: List<Article>): String {
        val type = object : TypeToken<List<Article>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toArticleUIList(value: String): List<Article> {
        val type = object : TypeToken<List<Article>>() {}.type
        return gson.fromJson(value, type)
    }

    // Cart
    @TypeConverter
    fun fromArticleInCartModelList(value: List<ArticleInCartModel>): String {
        val type = object : TypeToken<List<ArticleInCartModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toArticleInCartModelList(value: String): List<ArticleInCartModel> {
        val type = object : TypeToken<List<ArticleInCartModel>>() {}.type
        return gson.fromJson(value, type)
    }
}