package com.example.palindromeunittesting

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class HelperTest {
    lateinit var helper: Helper
    @Before
    fun setUp() {
        println("Before every test case")
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("After every test case")
    }

    @Test
    fun isPalindrome_input_level_true() {
        //Arrange
        //helper = Helper()

        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true,  result)
    }

    @Test
    fun isPalindrome_input_emptystring_true() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("")
        //Assert
        assertEquals(true,  result)
    }

    @Test
    fun isPalindrome_input_ab_false() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("ab")
        //Assert
        assertEquals(false,  result)
    }
}