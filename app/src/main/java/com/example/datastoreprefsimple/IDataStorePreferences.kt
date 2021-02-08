package com.example.datastoreprefsimple

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

/**
 * author：tdq
 * date：2021/2/7
 * description：
 */
interface IDataStorePreferences {

    /***
     * 读取DataStore-字符串
     *
     * @param stringKey 键
     */
    fun readStringData(stringKey: Preferences.Key<String>): Flow<String>

    /***
     * 读取DataStore-boolean
     *
     * @param booleanKey 键
     */
    fun readBooleanData(booleanKey: Preferences.Key<Boolean>): Flow<Boolean>

    /***
     * 读取DataStore-boolean
     *
     * @param intKey 键
     */
    fun readIntData(intKey: Preferences.Key<Int>): Flow<Int>
}