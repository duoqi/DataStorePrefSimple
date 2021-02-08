package com.example.datastoreprefsimple

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * author：tdq
 * date：2021/2/7
 * description：
 */
object UserDataStore {

    private val dataStore = App.getContext().createDataStore("data_store_test")

    fun readStringData(stringKey: Preferences.Key<String>): Flow<String> {
        return dataStore.data.catch {
            // 当读取数据遇到错误时，如果是 `IOException` 异常，发送一个 emptyPreferences 来重新使用
            // 但是如果是其他的异常，最好将它抛出去，不要隐藏问题
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[stringKey] ?: ""
        }
    }

    suspend fun saveStringData(stringKey: Preferences.Key<String>, value: String) {
        dataStore.edit {
            it[stringKey] = value
        }
    }
}
