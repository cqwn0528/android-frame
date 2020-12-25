package com.android.frame_master.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

object DataStoreUtil {
    lateinit var mDataStorePre: DataStore<Preferences>

    fun init(context: Context) {
        mDataStorePre = context.createDataStore("HintTest")
    }

    suspend inline fun <reified T : Any> saveData(key: String, value: T) = when (T::class) {
        String::class -> mDataStorePre.edit { it[preferencesKey<T>(key)] = value }
        Int::class -> mDataStorePre.edit { it[preferencesKey<T>(key)] = value }
        Boolean::class -> mDataStorePre.edit { it[preferencesKey<T>(key)] = value }
        else -> throw IllegalArgumentException("Type not supported: ${T::class.java}")
    }

    suspend inline fun <reified T : Any> getData(key: String) = when (T::class) {
        String::class -> mDataStorePre.data.map { it[preferencesKey<T>(key)] ?: "" }.first() as T
        Int::class -> mDataStorePre.data.map { it[preferencesKey<T>(key)] ?: 0 }.first() as T
        Boolean::class -> mDataStorePre.data.map { it[preferencesKey<T>(key)] ?: false }
            .first() as T
        else -> throw IllegalArgumentException("Type not supported: ${T::class.java}")
    }
}


/*
class DataStoreUtil private constructor(){
    lateinit var mDataStorePre : DataStore<Preferences>
    fun init(context : Context) {
        mDataStorePre = context.createDataStore("HintTest")
    }
    companion object {
        val instance: DataStoreUtil by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { DataStoreUtil() }
    }
}

suspend inline fun <reified T : Any> dataStoreSave(key: String,value: T) = when(T::class){
    String::class -> DataStoreUtil.instance.mDataStorePre.edit { it[preferencesKey<T>(key)] = value }
    Int::class -> DataStoreUtil.instance.mDataStorePre.edit { it[preferencesKey<T>(key)] = value }
    Boolean::class -> DataStoreUtil.instance.mDataStorePre.edit { it[preferencesKey<T>(key)] = value }
    else -> throw IllegalArgumentException("Type not supported: ${T::class.java}")
}

suspend inline fun <reified T : Any> dataStoreRead(key : String) = when(T::class){
    String::class -> DataStoreUtil.instance.mDataStorePre.data.map { it[preferencesKey<T>(key)] ?: "" }.first() as T
    Int::class -> DataStoreUtil.instance.mDataStorePre.data.map { it[preferencesKey<T>(key)] ?: 0 }.first() as T
    Boolean::class -> DataStoreUtil.instance.mDataStorePre.data.map { it[preferencesKey<T>(key)] ?: false }.first() as T
    else -> throw IllegalArgumentException("Type not supported: ${T::class.java}")
}*/
