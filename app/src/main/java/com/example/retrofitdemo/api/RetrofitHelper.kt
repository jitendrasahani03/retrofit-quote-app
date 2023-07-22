package com.example.retrofitdemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*
RetrofitHelper is user-defined abstract class. The method getInstance() creates instance of Retrofit and returns
GsonConverterFactory.create() convert JSON response to POJO(Class Object here)
 */

abstract class RetrofitHelper {
    companion object {
        private var INSTANCE: Retrofit? = null
        private const val BASE_URL = "https://quotable.io"
        fun getInstance(): Retrofit {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build()
                }
            }
            return INSTANCE!!
        }
    }
}