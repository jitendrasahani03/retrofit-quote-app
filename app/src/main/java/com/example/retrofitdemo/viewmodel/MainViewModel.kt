package com.example.retrofitdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.model.QuoteList
import com.example.retrofitdemo.repository.QuoteRespository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
/*
This class is called immediately after the mainActivity class.
It accept QuoteRepository object in constructor.
 */
class MainViewModel(private val Respository: QuoteRespository): ViewModel() {

    init {
        GlobalScope.launch {
            Respository.getQuotes(1)  }
    }

    fun getQuotes():LiveData<QuoteList>{
        return Respository.quotes()
    }
}