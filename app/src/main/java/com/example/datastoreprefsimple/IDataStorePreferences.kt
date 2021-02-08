package com.example.datastoreprefsimple

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

/**
 * author：tdq
 * date：2021/2/7
 * description：DataStore接口
 */
interface IDataStorePreferences {

    /***
     * 读取DataStore-字符串
     *
     * @param stringKey 键
     * @return Flow<String>
     */
    suspend fun readStringData(stringKey: Preferences.Key<String>): Flow<String>

    /***
     * 读取DataStore-boolean
     *
     * @param booleanKey 键
     * @return Flow<Boolean>
     */
    suspend fun readBooleanData(booleanKey: Preferences.Key<Boolean>): Flow<Boolean>

    /***
     * 读取DataStore-boolean
     *
     * @param intKey 键
     * @return Flow<Int>
     */
    suspend fun readIntData(intKey: Preferences.Key<Int>): Flow<Int>

    /***
     * 保存DataStore-string
     *
     * @param stringKey 键
     */
    suspend fun saveStringData(stringKey: Preferences.Key<String>, value: String = "")

    /***
     * 保存DataStore-int
     *
     * @param intKey 键
     */
    suspend fun saveIntData(intKey: Preferences.Key<Int>, value: Int = 0)

    /***
     * 保存DataStore-int
     *
     * @param booleanKey 键
     */
    suspend fun saveBooleanData(booleanKey: Preferences.Key<Boolean>, value: Boolean = false)

    /***
     * 清除所有数据
     */
    suspend fun clearAllData()

}