package com.example.retrofitdemo.model
/*
QuoteList is JSON body structure and variable of json response
 */
data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)