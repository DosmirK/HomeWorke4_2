package com.example.homeworke4_2.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.homeworke4_2.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table ORDER BY fname ASC")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM love_table ORDER BY fname ASC")
    fun getAllHistory(): LiveData<List<LoveModel>>
}