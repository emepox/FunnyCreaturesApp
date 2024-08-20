package com.example.funnycreaturesapp.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.funnycreaturesapp.models.UserSettings

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUser(user: UserSettings)

    @Query("SELECT * FROM user_table WHERE username = :username AND :password LIMIT 1")
    suspend fun getUser(username: String, password: String): UserSettings?

    @Query("SELECT * FROM user_table WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Int): UserSettings?

    @Query("UPDATE user_table SET " +
            "username = COALESCE(:username, username)," +
            "email = COALESCE(:email, email)," +
            "password = COALESCE(:password, password)" +
            "WHERE id = :id"
    )
    suspend fun updateUserFields(
        id: Int,
        username: String?,
        email: String?,
        password: String?,
    )

    @Update
    suspend fun updateUser(user: UserSettings)
}