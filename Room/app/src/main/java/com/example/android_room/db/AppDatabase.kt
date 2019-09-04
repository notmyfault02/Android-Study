package com.example.android_room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_room.db.entity.MemoEntity

@Database(entities = arrayOf(MemoEntity::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

}