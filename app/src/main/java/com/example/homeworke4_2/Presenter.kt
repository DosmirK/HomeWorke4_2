package com.example.homeworke4_2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(var view: LoveView) {

    val modelApi = RetrofitService().api

    fun getPercentage(firstName: String, secondName: String){
        modelApi.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let{
                    view.viewResult(it)
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.showError(t.message.toString())
            }
        })
    }
}