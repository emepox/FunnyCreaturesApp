package com.example.funnycreaturesapp.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funnycreaturesapp.models.UserSettings
import com.example.funnycreaturesapp.db.dataStore.SessionManager
import com.example.funnycreaturesapp.db.room.AppDatabase
import com.example.funnycreaturesapp.db.room.UserRepository
import kotlinx.coroutines.flow.first

class UserSettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()
    private val userRepository = UserRepository(userDao)
    private val sessionManager = SessionManager(application.applicationContext)

    suspend fun signUp(
        username: String,
        email: String,
        password: String,
    ) {
        val user = UserSettings(
            username = username,
            email = email,
            password = password,
        )
        userRepository.setUser(user)
    }

    suspend fun logIn(
        username: String,
        password: String,
    ): Boolean {
        val user = userRepository.getUser(username, password)
        return if (user != null) {
            sessionManager.saveUserSession(user.id)
            true
        } else {
            false
        }
    }

    suspend fun logOut() {
        sessionManager.clearSession()
    }

    suspend fun saveNewData(username: String, email: String, password: String) {
        sessionManager.userSession.first()?.run {
            userRepository.updateUserFields(
                id = this,
                username = username.ifEmpty { null },
                email = email.ifEmpty { null },
                password = password.ifEmpty { null },
            )
        }
    }


    companion object {
        fun userCredentialsViewModelFactory(application: Application): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(UserSettingsViewModel::class.java)) {
                        return UserSettingsViewModel(application) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }
}