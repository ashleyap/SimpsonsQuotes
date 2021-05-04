package uca.edu.simpsonsquotes.utils

import uca.edu.simpsonsquotes.model.Quote
import java.lang.Exception

sealed class DataState {
    object Idle: DataState()
    data class Success(val quotes: List<Quote>): DataState()
    data class Error(val exception: Exception): DataState()
    object Loading: DataState()
}