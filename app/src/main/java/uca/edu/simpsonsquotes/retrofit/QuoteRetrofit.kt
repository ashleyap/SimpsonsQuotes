package uca.edu.simpsonsquotes.retrofit

import retrofit2.http.GET

interface QuoteRetrofit {
    @GET("quotes?count=10")
    suspend fun get(): List<QuoteNetworkEntity>
}