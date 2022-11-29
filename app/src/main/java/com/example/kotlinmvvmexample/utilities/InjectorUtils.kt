package com.example.kotlinmvvmexample.utilities

import com.example.kotlinmvvmexample.data.FakeDatabase
import com.example.kotlinmvvmexample.data.QuoteRepository
import com.example.kotlinmvvmexample.ui.quotes.QuotesViewModelFactory

/**
 * @author Lior Hazael
 */
object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

}