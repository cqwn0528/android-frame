package com.android.frame_master.util

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

object PreStore {

    // 创建dataStore
    var dataStore: DataStore<Preferences> = CtxUtil.getAplContext().createDataStore(
        name = Constant.USER_INFO
    )

    suspend inline fun <reified T : Any> saveData(key: String, value: T) {
        if (T::class == String::class || T::class == Int::class || T::class == Double::class || T::class == Boolean::class || T::class == Long::class || T::class == Float::class) {
            dataStore.edit { it[preferencesKey<T>(key)] = value }
        } else {
            throw IllegalArgumentException("Type not supported: ${T::class.java}")
        }
    }

    suspend inline fun <reified T : Any> getData(key: String) = when (T::class) {
        String::class -> {
            dataStore.data.map { it[preferencesKey<T>(key)] ?: "" }.first()
        }
        Int::class -> {
            dataStore.data.map { it[preferencesKey<T>(key)] ?: 0 }.first()
        }
        Boolean::class -> {
            dataStore.data.map { it[preferencesKey<T>(key)] ?: false }.first()
        }
        Float::class -> {
            dataStore.data.map { it[preferencesKey<T>(key)] ?: 0F }.first()
        }
        Long::class -> {
            dataStore.data.map { it[preferencesKey<T>(key)] ?: 0L }.first()
        }
        Double::class -> {
            dataStore.data.map { it[preferencesKey<T>(key)] ?: 0.0 }.first()
        }
        else -> {
            throw IllegalArgumentException("Type not supported: ${T::class.java}")
        }
    }
}