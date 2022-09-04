package com.android.frame_master.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * DataStore封装工具类
 * @author llw
 */
object DsUtil {
    private const val TAG = "PreStore"

    // 创建DataStore
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Study")

    // DataStore变量
    private val dataStore = CtxUtil.getAplContext().dataStore

    /**
     * 存数据
     */
    fun <T> putData(key: String, value: T) {
        runBlocking {
            when (value) {
                is Int -> dataStore.edit {
                    it[intPreferencesKey(key)] = value
                }
                is Long -> dataStore.edit {
                    it[longPreferencesKey(key)] = value
                }
                is String -> dataStore.edit {
                    it[stringPreferencesKey(key)] = value
                }
                is Boolean -> dataStore.edit {
                    it[booleanPreferencesKey(key)] = value
                }
                is Float -> dataStore.edit {
                    it[floatPreferencesKey(key)] = value
                }
                is Double -> dataStore.edit {
                    it[doublePreferencesKey(key)] = value
                }
                else -> LogUtil.error(TAG, "This type cannot be saved to the Data Store")
            }
        }
    }

    /**
     * 存储Int数据
     */
    fun getIntData(key: String, default: Int = 0): Int = runBlocking {
        return@runBlocking dataStore.data.map {
            it[intPreferencesKey(key)] ?: default
        }.first()
    }

    /**
     * 取出Long数据
     */
    fun getLongData(key: String, default: Long = 0): Long = runBlocking {
        return@runBlocking dataStore.data.map {
            it[longPreferencesKey(key)] ?: default
        }.first()
    }

    /**
     * 取出String数据
     */
    fun getStringData(key: String, default: String? = null): String = runBlocking {
        return@runBlocking dataStore.data.map {
            it[stringPreferencesKey(key)
            ] ?: default
        }.first()!!
    }

    /**
     * 取出Boolean数据
     */
    fun getBooleanData(key: String, default: Boolean = false): Boolean = runBlocking {
        return@runBlocking dataStore.data.map {
            it[booleanPreferencesKey(key)] ?: default
        }.first()
    }

    /**
     * 取出Float数据
     */
    fun getFloatData(key: String, default: Float = 0.0f): Float = runBlocking {
        return@runBlocking dataStore.data.map {
            it[floatPreferencesKey(key)] ?: default
        }.first()
    }

    /**
     * 取出Double数据
     */
    fun getDoubleData(key: String, default: Double = 0.00): Double = runBlocking {
        return@runBlocking dataStore.data.map {
            it[doublePreferencesKey(key)] ?: default
        }.first()
    }

    /**
     * 清空数据
     */
    fun clearData() = runBlocking { dataStore.edit { it.clear() } }
}
