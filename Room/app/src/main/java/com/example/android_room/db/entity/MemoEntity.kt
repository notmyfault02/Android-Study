package com.example.android_room.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MemoEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var title: String,
        var content: String,
        var date: String
) {
        constructor(): this(0,"", "", "")
}