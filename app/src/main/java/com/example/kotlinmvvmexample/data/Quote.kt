package com.example.kotlinmvvmexample.data

/**
 * @author Lior Hazael
 */
data class Quote(
    val quoteText: String,
    var author: String) {


    override fun toString(): String {
        return "$quoteText - $author"
    }


}