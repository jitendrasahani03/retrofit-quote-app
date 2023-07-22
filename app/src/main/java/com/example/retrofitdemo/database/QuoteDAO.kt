package com.example.retrofitdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitdemo.model.Result
/*
QuoteDAO  (Data Access Object) is interface to hold all methods of CRUD operation (Insert,Delete,Update,Query).
@Dao is mandatory before interface
 */

@Dao
interface QuoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun addQuotes(result: List<Result>)
    @Query("SELECT * FROM quote")
    fun getQuotes():List<Result>
}