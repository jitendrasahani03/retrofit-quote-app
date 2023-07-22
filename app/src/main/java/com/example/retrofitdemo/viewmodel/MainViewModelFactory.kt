package com.example.retrofitdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.retrofitdemo.repository.QuoteRespository
/*
Return the MainViewModel object
 */
class MainViewModelFactory(private val Respository: QuoteRespository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return MainViewModel(Respository) as T
    }
}