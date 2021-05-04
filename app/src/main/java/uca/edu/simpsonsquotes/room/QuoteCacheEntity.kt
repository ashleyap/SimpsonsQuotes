package uca.edu.simpsonsquotes.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
class QuoteCacheEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "quote")
    var quote: String,

    @ColumnInfo(name = "character")
    var character: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "characterDirection")
    var characterDirection: String
)