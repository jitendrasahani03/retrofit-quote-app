package com.example.retrofitdemo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.NetworkUtil.NetworkUtils
import com.example.retrofitdemo.api.QuoteAPI
import com.example.retrofitdemo.database.QuoteDatabase
import com.example.retrofitdemo.model.QuoteList
/*
Here we interacting between the response of API call and database.

 */
class QuoteRespository(private val quoteAPI: QuoteAPI,
                       private val quoteDatabase: QuoteDatabase,
                       private val applicationContext: Context
                       ) {
    private val quoteLiveDataAPI = MutableLiveData<QuoteList>()

    suspend fun getQuotes(page:Int){
        //checking internet state (ON/OFF)
        if (NetworkUtils.isNetworkAvailable(applicationContext)){
            val result = quoteAPI.getQuotes(page)
            if (result?.body()!=null){
                //insert quote into quote table to avail offline
                quoteDatabase.getQuoteDao().addQuotes(result.body()!!.results)
                //provide data to display on UI
                quoteLiveDataAPI.postValue(result.body())
            }
        }
        else
        {
            //get data from local database
            val quotesFromDb = quoteDatabase.getQuoteDao().getQuotes()
            //creating an object of QuoteList() because mutableLiveData accept data of  QuoteList
            val quoteList = QuoteList(1,1,1,quotesFromDb,1,1)
            //adding value to mutableLiveData<>
            quoteLiveDataAPI.postValue(quoteList)
        }


    }

    fun quotes():LiveData<QuoteList>{
        return quoteLiveDataAPI
    }
}