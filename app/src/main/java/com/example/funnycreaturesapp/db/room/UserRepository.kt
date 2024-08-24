package com.example.funnycreaturesapp.db.room

import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.models.Article
import com.example.funnycreaturesapp.models.UserSettings

class UserRepository(private val userDao: UserDao) {
    suspend fun setUser(user: UserSettings) = userDao.setUser(user)
    suspend fun getUser(username: String, password: String): UserSettings? =
        userDao.getUser(username, password)

    suspend fun getUserById(id: Int): UserSettings? = userDao.getUserById(id)
    suspend fun updateUserFields(id: Int, username: String?, email: String?, password: String?) =
        userDao.updateUserFields(id, username, email, password)

    suspend fun updateCart(userId: Int, newCartList: List<ArticleInCartModel>) {
        userDao.getUserById(userId)?.let { user ->
            userDao.updateUser(user.copy(cart = newCartList))
        }
    }
    suspend fun updateFavourites(userId: Int, newFavouritesList: List<Article>) {
        userDao.getUserById(userId)?.let { user ->
            userDao.updateUser(user.copy(favourites = newFavouritesList))
        }
    }
}