package com.example.nusa_guide.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStoreManager private constructor(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("user_prefs")

    companion object {
        val BEARER_TOKEN = stringPreferencesKey("BEARER_TOKEN")
        val USER_ID = intPreferencesKey("USER_ID")

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: DataStoreManager? = null

        fun getInstance(context: Context): DataStoreManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DataStoreManager(context).also { INSTANCE = it }
            }
        }
    }

    val bearerToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[BEARER_TOKEN]
        }

    val userId: Flow<Int?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_ID]
        }

    suspend fun saveBearerToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[BEARER_TOKEN] = token
        }
    }

    suspend fun saveUserId(id: Int) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID] = id
        }
    }

    suspend fun clearBearerToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(BEARER_TOKEN)
        }
    }

    suspend fun clearUserId() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_ID)
        }
    }

    suspend fun getBearerToken(): String? {
        return context.dataStore.data.first()[BEARER_TOKEN]
    }

    suspend fun getUserId(): Int? {
        return context.dataStore.data.first()[USER_ID]
    }
}