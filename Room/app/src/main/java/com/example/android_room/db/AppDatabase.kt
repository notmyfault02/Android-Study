package com.example.android_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_room.db.dao.MemoDao
import com.example.android_room.db.entity.MemoEntity

@Database(entities = [MemoEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun MemoDao(): MemoDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "memo.db")
                        .build()
                }
            }

            return INSTANCE
        }

    }
}