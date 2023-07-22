package com.example.retrofitdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.api.QuoteAPI
import com.example.retrofitdemo.model.QuoteList

class QuoteRespository(private val quoteAPI: QuoteAPI) {
    private val quoteLiveData = MutableLiveData<QuoteList>()

    suspend fun getQuote(page:Int){
        val result = quoteAPI.getQuotes(page)
        if (result?.body()!=null){
            quoteLiveData.postValue(result.body())
        }
    }

    fun quotes():LiveData<QuoteList>{
        return quoteLiveData
    }
}