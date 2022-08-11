package com.miqdad.android.simpletranslateapp.api.network

import com.miqdad.android.simpletranslateapp.api.data.TranslateResponse
import com.miqdad.android.simpletranslateapp.api.data.TranslateResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("en/{word}")
    fun getWord(
        @Path("word") word : String
    ): Call<ArrayList<TranslateResponseItem>>
}