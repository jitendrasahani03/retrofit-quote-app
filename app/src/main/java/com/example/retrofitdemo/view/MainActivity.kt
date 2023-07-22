package com.example.retrofitdemo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.R
import com.example.retrofitdemo.api.QuoteAPI
import com.example.retrofitdemo.api.RetrofitClient
import com.example.retrofitdemo.repository.QuoteRespository
import com.example.retrofitdemo.viewmodel.MainViewModel
import com.example.retrofitdemo.viewmodel.MainViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteAPI: QuoteAPI by lazy {
            RetrofitClient.getInstance().create(QuoteAPI::class.java)
        }// quoteAPI = RetrofitClient.getInstance().create(QuoteAPI::class.java)
        val repository = QuoteRespository(quoteAPI)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)





        /*GlobalScope.launch {
            val responseResult = quoteAPI.getQuotes(1)
            Log.d(TAG, "Quote result: ${responseResult.body().toString()}")
            responseResult?.body()?.results?.forEach {
                Log.d(TAG, "id: ${it._id}:$ Content: ${it.content}")
            }
        }*/

       mainViewModel.getQuotes().observe(this,{it->
           for (result in it.results) {
               Log.d(TAG,"Quote Result : ${result.content}")
           }

       })
    }
}