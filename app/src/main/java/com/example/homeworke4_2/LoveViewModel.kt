package com.example.homeworke4_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.homeworke4_2.remote.LoveModel

class LoveViewModel: ViewModel() {
    private val repository = Repository()

    fun getPercentage(firstName: String, secondName: String): LiveData<LoveModel> =
        repository.getPercentage(firstName, secondName)
}