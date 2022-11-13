package com.example.palindromeunittesting

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.google.gson.Gson

class QuoteManager() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var quoteList: Array<Quote> = emptyArray()
    private var index = 0


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun loadQuoteFromAssets(context: Context, fileName: String): Array<Quote> {
        //Open quotes.json, it returns InputStream
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available() //Find size of opened file.
        val buffer = ByteArray(size) //Create buffer(i.e ByteArray) of required size
        inputStream.read(buffer) //read from input stream to buffer
        inputStream.close() //Close inputStream
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<Quote>::class.java)
        return quoteList
    }

    fun loadQuotes(arraOfQuotes: Array<Quote>) {
        quoteList = arraOfQuotes
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index % quoteList.size]

    fun previousQuote() = quoteList[(--index + quoteList.size) % quoteList.size]

}