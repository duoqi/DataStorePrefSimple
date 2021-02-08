package com.example.datastoreprefsimple

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore

/**
 * author：tdq
 * date：2021/2/8
 * description：用户DataStore
 */
object UserDataStore : DataStorePreferencesImpl() {

    private const val storeName = "user_data_store"

    override fun getDataStore(): DataStore<Preferences> = App.getContext().createDataStore(storeName)

}