package com.example.funnycreaturesapp.db.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.funnycreaturesapp.db.dataStore.DataStoreSingleton.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SessionManager(context: Context) {

    private val dataStore: DataStore<Preferences> = context.dataStore
    suspend fun saveUserSession(userId: Int) {
        dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = userId
        }
    }

    val userSession: Flow<Int?> = dataStore.data.map { preferences ->
        preferences[USER_ID_KEY]
    }

    suspend fun clearSession() {
        dataStore.edit { preferences -> preferences.clear() }
    }

    companion object {
        val USER_ID_KEY = intPreferencesKey("user_id")
    }
}

object DataStoreSingleton {
    private const val DATASTORE_NAME = "user_session"

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)

}