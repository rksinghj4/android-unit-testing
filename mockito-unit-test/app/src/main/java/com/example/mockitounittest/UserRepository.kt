package com.example.mockitounittest

class UserRepository {
    val users = listOf<User>(
        User(1, "Raj", "raj@gmail.com", "22222a"),
        User(2, "Raju", "raju@gmail.com", "22222b"),
        User(3, "Raja", "raja@gmail.com", "22222c")
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}