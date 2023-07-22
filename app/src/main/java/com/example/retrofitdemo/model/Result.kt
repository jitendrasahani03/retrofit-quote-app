package com.example.retrofitdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
/*
Result is JSON body structure and variable of json response .

Here, we are using the same class for both repository (API, Database). If we want to can create
separate entity(tableName)/class as per the requirement.
@PrimaryKey mean the variable will act as primary key for each row entry.
 */
@Entity(tableName = "quote")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val quoteId:Int,                         //primary key variable
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
)