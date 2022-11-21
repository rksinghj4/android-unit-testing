package com.example.roomdbunittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuotesDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        quotesDao.insertQuote(Quote(id = 0, text = "This is first quote", "Raj"))
        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("This is first quote", result[0].text)
    }

    @Test
    fun deleteQuote_expectedZeroQuote() = runBlocking {
        quotesDao.insertQuote(Quote(id = 0, text = "This is first quote", "Raj"))
        quotesDao.delete()

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(0, result.size)
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }
}