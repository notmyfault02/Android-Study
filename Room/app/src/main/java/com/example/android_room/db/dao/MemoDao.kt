package com.example.android_room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_room.db.entity.MemoEntity

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg memo: MemoEntity)

    @Query ("SELECT * FROM memoentity")
    fun getAll(): Array<MemoEntity>
}