package ru.mephi.info.service.interfaces

import ru.mephi.info.model.User

interface UserService {
    fun getUser(id: Int): User

    fun findByEmail(email: String) : User?

    fun findByLogin(login: String) : User

    fun getAllUsers() : List<User>

    fun createUser(user: User)

    fun updateUser(id: Int, user: User)

    fun deleteUser(id: Int)
}