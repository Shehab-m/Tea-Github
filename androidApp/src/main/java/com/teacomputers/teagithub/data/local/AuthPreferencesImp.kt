package com.teacomputers.teagithub.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AuthPreferencesImp(context: Context) : AuthPreferences {

    companion object {
        private const val PREFERENCES_FILE_NAME = "auth_file"
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCES_FILE_NAME)

    private val dataStore = context.dataStore


    override suspend fun getAccessToken(): String? {
        return dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN_KEY]
        }.first()
    }

    override suspend fun saveAccessToken(token: String) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = token
        }
    }

    override suspend fun clearAccessToken() {
        dataStore.edit { preferences ->
            preferences.remove(ACCESS_TOKEN_KEY)
        }
    }

}