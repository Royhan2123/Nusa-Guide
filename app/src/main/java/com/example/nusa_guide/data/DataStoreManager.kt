package com.example.nusa_guide.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class DataStoreManager private constructor(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("user_prefs")

    companion object {
        val BEARER_TOKEN = stringPreferencesKey("BEARER_TOKEN")

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: DataStoreManager? = null

        fun getInstance(context: Context): DataStoreManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DataStoreManager(context).also { INSTANCE = it }
            }
        }
    }
    suspend fun saveBearerToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[BEARER_TOKEN] = token
        }
    }

    suspend fun getBearerToken(): String? {
        return context.dataStore.data.first()[BEARER_TOKEN]
    }

    suspend fun clearBearerToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(BEARER_TOKEN)
        }
    }
}