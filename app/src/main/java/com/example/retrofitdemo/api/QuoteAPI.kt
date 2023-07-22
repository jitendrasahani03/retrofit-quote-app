package com.example.retrofitdemo.api

import com.example.retrofitdemo.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int): Response<QuoteList>   // LiveData<List<Quote>> add suspend to run in background thread
}