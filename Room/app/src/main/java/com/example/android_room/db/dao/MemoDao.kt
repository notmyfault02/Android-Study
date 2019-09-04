package com.example.android_room.db.dao

import androidx.room.*
import com.example.android_room.db.entity.MemoEntity

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(vararg memo: MemoEntity)

    @Query ("SELECT * FROM memoentity")
    fun getAll(): List<MemoEntity>

    @Delete
    fun deleteAll(memo: List<MemoEntity>)
}