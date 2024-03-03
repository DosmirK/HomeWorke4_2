package com.example.homeworke4_2.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "love_table")
data class LoveModel(
    var fname: String,
    var sname: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
)
