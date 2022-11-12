package com.example.palindromeunittesting

class Helper {
    fun isPalindrome(str: String): Boolean {
        var i = 0
        var j = str.length - 1

        while (i < j) {
         if (str[i] != str[j]) {
             return false
         }
            i++
            j--
        }
        return true
    }
}

fun main() {
    println(Helper().isPalindrome(""))
    println(Helper().isPalindrome("a"))
    println(Helper().isPalindrome("ab"))
    println(Helper().isPalindrome("aa"))
    println(Helper().isPalindrome("aba"))
}