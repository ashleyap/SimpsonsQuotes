package uca.edu.simpsonsquotes.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uca.edu.simpsonsquotes.retrofit.NetworkMapper
import uca.edu.simpsonsquotes.retrofit.QuoteRetrofit
import uca.edu.simpsonsquotes.room.CacheMapper
import uca.edu.simpsonsquotes.room.QuoteDao
import uca.edu.simpsonsquotes.utils.DataState

class QuoteRepository constructor(
    private val quoteDao: QuoteDao,
    private val quoteRetrofit: QuoteRetrofit,
    private val cacheMapper: CacheMapper,
    private val newtworkMapper: NetworkMapper
) {
    suspend fun getQuotes(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val quoteData = quoteRetrofit.get()
            val quoteMap = newtworkMapper.mapFromEntityList(quoteData)
            for (tmpQuote in quoteMap){
                quoteDao.insert(cacheMapper.mapToEntity(tmpQuote))
            }
            val cacheQuote = quoteDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheQuote)))
        } catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}