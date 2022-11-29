package com.example.kotlinmvvmexample.data

/**
 * @author Lior Hazael
 */
class FakeDatabase private constructor() {

    var quoteDao = QuoteDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }

}