package uca.edu.simpsonsquotes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uca.edu.simpsonsquotes.repository.QuoteRepository
import uca.edu.simpsonsquotes.retrofit.NetworkMapper
import uca.edu.simpsonsquotes.retrofit.QuoteRetrofit
import uca.edu.simpsonsquotes.room.CacheMapper
import uca.edu.simpsonsquotes.room.QuoteDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideQuoteRepository(
        quoteDao: QuoteDao,
        quoteRetrofit: QuoteRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): QuoteRepository {
        return QuoteRepository(quoteDao, quoteRetrofit, cacheMapper, networkMapper)
    }
}