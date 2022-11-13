package com.example.palindromeunittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Before
    fun setUp() {
        println("Before every test")
    }

    @After
    fun tearDown() {
        println("After every test")
    }

    @Test(expected = FileNotFoundException::class)
    fun loadQuoteFromAssets_without_filename() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.loadQuoteFromAssets(context, "")
        //Assert
    }

    @Test(expected = JsonSyntaxException::class)
    fun loadQuoteFromAssets_from_invalid_assest_expected_Exception() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.loadQuoteFromAssets(context, "malformed.json")
        //Assert
    }

    @Test
    fun loadQuoteFromAssets_from_valid_assest_expected_count() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.loadQuoteFromAssets(context, "quotes.json")
        //Assert
        assertEquals(11, quoteManager.quoteList.size)
    }

    @Test
    fun previousQuotes() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.loadQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is first quote", "2"),
                Quote("This is first quote", "3"),
                Quote("This is first quote", "4"),
                Quote("This is first quote", "5"),
                Quote("This is first quote", "6"),
            )
        )
        val previousQuote = quoteManager.previousQuote()
        //Assert
        assertEquals("6", previousQuote.author)
    }

    @Test
    fun nextQuotes() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.loadQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is first quote", "2"),
                Quote("This is first quote", "3"),
                Quote("This is first quote", "4"),
                Quote("This is first quote", "5"),
                Quote("This is first quote", "6"),
            )
        )
        val nextQuote = quoteManager.nextQuote()
        //Assert
        assertEquals("2", nextQuote.author)
    }
}