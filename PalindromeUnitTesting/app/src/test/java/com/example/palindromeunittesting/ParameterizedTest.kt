package com.example.palindromeunittesting

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParameterizedTest(val input: String, val expectedValue: Boolean) {

    @Test
    fun test() {
        val helper= Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index} : {0} is pailndrome {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("", true),
                arrayOf("Hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("aa", true),
                arrayOf("ab", false),
            )
        }
    }
}