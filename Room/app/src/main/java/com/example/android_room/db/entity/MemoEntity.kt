package com.example.android_room.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoEntity(
        @PrimaryKey(autoGenerate = true)
        var title: String,
        var content: String,
        var date: String
)