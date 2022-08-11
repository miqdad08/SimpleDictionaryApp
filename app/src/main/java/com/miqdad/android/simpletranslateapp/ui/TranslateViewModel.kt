package com.miqdad.android.simpletranslateapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miqdad.android.simpletranslateapp.api.data.TranslateResponseItem
import com.miqdad.android.simpletranslateapp.api.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TranslateViewModel: ViewModel() {
    private val listData = MutableLiveData<ArrayList<TranslateResponseItem>>()

    fun getSearchApi(word : String){
        ApiClient.getApiService().getWord(word).enqueue(object : Callback<ArrayList<TranslateResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<TranslateResponseItem>>,
                response: Response<ArrayList<TranslateResponseItem>>
            ) {
                listData.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<TranslateResponseItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun getSearchUser():LiveData<ArrayList<TranslateResponseItem>> = listData
}