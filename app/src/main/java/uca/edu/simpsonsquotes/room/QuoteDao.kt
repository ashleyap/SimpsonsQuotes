package uca.edu.simpsonsquotes.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quoteEntity: QuoteCacheEntity): Long
    @Query("select * from quotes")
    suspend fun get(): List<QuoteCacheEntity>
}