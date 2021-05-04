package uca.edu.simpsonsquotes.intent

sealed class Intent {
    object GetQuoteEvent: Intent()
    object None: Intent()
}