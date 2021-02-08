package com.example.datastoreprefsimple

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * author：tdq
 * date：2021/2/7
 * description：DataStore实现类
 */
abstract class DataStorePreferencesImpl : IDataStorePreferences {

    /***
     * 获取dataStore
     */
    abstract fun getDataStore(): DataStore<Preferences>

    override suspend fun readStringData(stringKey: Preferences.Key<String>): Flow<String> {
        return getDataStore().data.catch {
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

    override suspend fun saveStringData(stringKey: Preferences.Key<String>, value: String) {
        getDataStore().edit {
            it[stringKey] = value
        }
    }

    override suspend fun readBooleanData(booleanKey: Preferences.Key<Boolean>): Flow<Boolean> {
        return getDataStore().data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[booleanKey] ?: false
        }
    }

    override suspend fun readIntData(intKey: Preferences.Key<Int>): Flow<Int> {
        return getDataStore().data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[intKey] ?: 0
        }
    }

    override suspend fun saveIntData(intKey: Preferences.Key<Int>, value: Int) {
        getDataStore().edit {
            it[intKey] = value
        }
    }

    override suspend fun saveBooleanData(booleanKey: Preferences.Key<Boolean>, value: Boolean) {
        getDataStore().edit {
            it[booleanKey] = value
        }
    }

    override suspend fun clearAllData() {
        getDataStore().edit { it.clear() }
    }

}
