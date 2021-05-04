package uca.edu.simpsonsquotes.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuoteCacheEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    companion object{
        val DATABASE_NAME = "QuoteDB"
    }
    abstract fun quoteDao(): QuoteDao
}