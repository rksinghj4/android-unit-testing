package com.example.palindromeunittesting

import android.content.Context
import android.content.res.AssetManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class QuoteManagerUnitTest {
    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test() {
        val testStream = QuoteManagerUnitTest::class.java.getResourceAsStream("/myquotes.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val sut =  QuoteManager()
        sut.loadQuoteFromAssets(context, "")
        val quote = sut.getQuote()
        Assert.assertEquals("Life is a learning experience, only if you learn.", quote.text)
    }
}