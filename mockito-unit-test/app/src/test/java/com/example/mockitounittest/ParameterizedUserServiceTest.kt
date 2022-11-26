package com.example.mockitounittest

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(value = Parameterized::class)
class ParameterizedUserServiceTest(
    val email: String,
    val password: String,
    val loginStatus: LOGIN_STATUS,
    val expectedResult: String
) {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(
            userRepository.loginUser(
                email,
                password
            )
        ).thenReturn(loginStatus)
    }

    @Test
    fun testUserService() {
        val sut = UserService(userRepository)
        val status = sut.loginUser(email, password)
        Assert.assertEquals(expectedResult, status)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index} : For email: {0}, password: {1}, Login.Status: {2}, Login message: {3}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("abc@gmail.com", "12", LOGIN_STATUS.INVALID_USER, "User doesn't exist"),
                arrayOf("abc@gmail.com", "123", LOGIN_STATUS.INVALID_PASSWORD, "Password is invalid"),
                arrayOf("abc@gmail.com", "1234", LOGIN_STATUS.UNKNOWN_ERROR, "Unknown error occurred"),
                arrayOf("abc@gmail.com", "12345", LOGIN_STATUS.SUCCESS, "Logged in successfully")
            )
        }
    }
}