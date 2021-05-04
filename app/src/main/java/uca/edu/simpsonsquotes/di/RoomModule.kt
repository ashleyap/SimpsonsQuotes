package uca.edu.simpsonsquotes.di
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import uca.edu.simpsonsquotes.room.QuoteDao
import uca.edu.simpsonsquotes.room.QuoteDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideQuoteDb(@ApplicationContext context: Context): QuoteDatabase {
        return Room
            .databaseBuilder(context, QuoteDatabase::class.java, QuoteDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideQuoteDao(quoteDatabase: QuoteDatabase): QuoteDao {
        return quoteDatabase.quoteDao()
    }
}