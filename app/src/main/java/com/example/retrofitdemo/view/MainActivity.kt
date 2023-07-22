package com.example.retrofitdemo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.viewmodel.QuoteApplication
import com.example.retrofitdemo.R
import com.example.retrofitdemo.viewmodel.MainViewModel
import com.example.retrofitdemo.viewmodel.MainViewModelFactory

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        val quoteAPI: QuoteAPI by lazy {
            RetrofitClient.getInstance().create(QuoteAPI::class.java)
        }// quoteAPI = RetrofitClient.getInstance().create(QuoteAPI::class.java)

        val quoteDao: QuoteDAO by lazy {
            QuoteDatabase.getInstanceQuoteDb(this).getQuoteDao()
        }*/

        //val repository = QuoteRespository(quoteAPI,quoteDao)

        val repository = (application as QuoteApplication).initialize()
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)


       mainViewModel.getQuotes().observe(this,{it->
           for (result in it.results) {
               Log.d(TAG,"Quote Result : ${result.content}")
           }

       })
    }
}