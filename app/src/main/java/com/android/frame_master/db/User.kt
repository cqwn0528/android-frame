package com.android.frame_master.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) var userId: Long,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "user_name1", defaultValue = "china") var address: String,
    @Ignore var sex: Boolean
)