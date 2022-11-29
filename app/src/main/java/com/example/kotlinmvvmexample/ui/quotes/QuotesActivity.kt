package com.example.kotlinmvvmexample.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvmexample.R
import com.example.kotlinmvvmexample.data.Quote
import com.example.kotlinmvvmexample.utilities.InjectorUtils
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
        val quotesView = findViewById<TextView>(R.id.textView_quotes)
        val button = findViewById<Button>(R.id.button_add_quote)
        val quoteTxt = findViewById<EditText>(R.id.editText_quote)
        val authorTxt = findViewById<EditText>(R.id.editText_author)

        viewModel.getQuotes().observe(this) { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }

            quotesView.text = stringBuilder.toString()
        }

        button.setOnClickListener{
            val quote = Quote(quoteTxt.text.toString(), authorTxt.text.toString())
            viewModel.addQuote(quote)
            quoteTxt.setText("")
            authorTxt.setText("")
        }
    }
}