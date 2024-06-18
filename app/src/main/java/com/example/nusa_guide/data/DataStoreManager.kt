package com.example.nusa_guide.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("user_prefs")

    companion object {
        val BEARER_TOKEN = stringPreferencesKey("BEARER_TOKEN")
    }

    val bearerToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[BEARER_TOKEN]
        }

    suspend fun saveBearerToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[BEARER_TOKEN] = token
        }
    }

    suspend fun clearBearerToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(BEARER_TOKEN)
        }
    }
}