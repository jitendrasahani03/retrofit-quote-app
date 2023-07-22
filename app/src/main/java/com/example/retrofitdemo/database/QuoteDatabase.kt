package com.example.retrofitdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitdemo.model.Result

/*
QuoteDatabase extends RoomDatabase() . Here, we are creating Singleton instance of type (QuoteDatabase).
Result - A class with annotation @Entity
quoteDb - is name of database
synchronized - to have thread-safe operation
@Volatile - inform all other threads about change in current thread
 */

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDAO

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getInstanceQuoteDb(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context, QuoteDatabase::class.java, "quoteDb")
                        .build()
                }
            }
            return INSTANCE!!
        }

    }

}