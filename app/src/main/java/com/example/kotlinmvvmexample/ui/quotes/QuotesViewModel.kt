package com.example.kotlinmvvmexample.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmexample.data.Quote
import com.example.kotlinmvvmexample.data.QuoteRepository

/**
 * @author Lior Hazael
 */
class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}