package com.example.homeworke4_2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.homeworke4_2.remote.LoveModel
import com.example.homeworke4_2.remote.RetrofitService
import retrofit2.Call
import retrofit2.Response

class Repository {
    private val api = RetrofitService().api
    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel>{
        val liveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstName, secondName)
            .enqueue(object : retrofit2.Callback<LoveModel>{
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            liveData.postValue(it)
                        }
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }
            })
        return liveData
    }
}