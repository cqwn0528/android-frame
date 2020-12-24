package com.android.frame_master.util

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

object DataStoreUtil {

    private const val DATA_STORE_PREFERENCE_NAME = "DataStorePreference"//定义 DataStore 的名字
    private val mDataStorePre = CtxUtil.getAplContext().createDataStore(DATA_STORE_PREFERENCE_NAME)

    private suspend fun savePreInfo(value: String) {
        val preKey = preferencesKey<String>("12")
        mDataStorePre.edit { mutablePreferences ->
            mutablePreferences[preKey] = value
        }
    }

    private suspend fun readPreInfo(): String {
        val preKey = preferencesKey<String>("")
        val value = mDataStorePre.data.map { preferences -> preferences[preKey] ?: "" }
        return value.first()
    }
}