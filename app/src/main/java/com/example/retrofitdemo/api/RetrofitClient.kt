package com.example.retrofitdemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {
    abstract fun quoteAPI() : QuoteAPI
    companion object{
        private var INSTANCE: Retrofit? = null
        private val BASE_URL = "https://quotable.io"
        fun getInstance(): Retrofit{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create()).build()
                }
            }
            return INSTANCE!!
        }
    }
}