package com.example.android_room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_room.db.entity.MemoEntity

@Dao
interface MemoDao {
    @Insert
    fun insertAll(vararg memo: MemoEntity)
}