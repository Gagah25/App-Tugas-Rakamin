package com.example.rakaminsubmission.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rakaminsubmission.model.api.ApiService
import com.example.rakaminsubmission.model.response.DataResponse
import com.example.rakaminsubmission.model.response.ItemsItem
import retrofit2.Call
import retrofit2.Response

class MainViewModel: ViewModel() {

    var listData = MutableLiveData<ArrayList<ItemsItem>>()

    fun setData(){
        val client = ApiService.getApiService().getData(Extra_Id)
        client.enqueue(object : retrofit2.Callback<DataResponse>{
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful) {
                    val result = response.body()?.items
                    listData.postValue(result)
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }

        })
    }

    fun getDataViewModel(): LiveData<ArrayList<ItemsItem>>{
        return listData
    }

    companion object{
        const val Extra_Id: String = "\"\""
    }
}