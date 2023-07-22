package com.example.retrofitdemo.api

import com.example.retrofitdemo.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
/*
This is an interface which hold method's to fetch quote using Http GET or we can have POST
to send our own quote to the server
Response<type> is similar to LiveData<type> it runs in background thread
*/

interface QuoteAPI {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>
}