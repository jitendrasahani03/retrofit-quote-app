package com.example.retrofitdemo.viewmodel

import android.app.Application
import com.example.retrofitdemo.api.QuoteAPI
import com.example.retrofitdemo.api.RetrofitHelper
import com.example.retrofitdemo.database.QuoteDatabase
import com.example.retrofitdemo.repository.QuoteRespository
/*
Common class that can be use by different MainViewModel.
 */
class QuoteApplication:Application() {
    private lateinit var repository: QuoteRespository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    fun initialize():QuoteRespository{
        // quoteAPI = RetrofitClient.getInstance().create(QuoteAPI::class.java)
        val quoteAPI = RetrofitHelper.getInstance().create(QuoteAPI::class.java)

        //singleton object of quotedatabase which is abstract class. The getInstanceQuoteDb() method return singleton object
       val quoteDatabase = QuoteDatabase.getInstanceQuoteDb(applicationContext)

        //passing QuoteAPI and QuoteDatabase reference to repository
        repository = QuoteRespository(quoteAPI,quoteDatabase, applicationContext)
        return repository
    }
}