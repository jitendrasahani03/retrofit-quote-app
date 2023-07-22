package com.example.retrofitdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.model.QuoteList
import com.example.retrofitdemo.repository.QuoteRespository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val Respository: QuoteRespository): ViewModel() {

    init {
        GlobalScope.launch {
            Respository.getQuote(1)  }
    }

    fun getQuotes():LiveData<QuoteList>{
        return Respository.quotes()
    }
}