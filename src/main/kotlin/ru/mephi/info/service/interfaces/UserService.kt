package ru.mephi.info.service.interfaces

import org.springframework.security.core.userdetails.UserDetailsService
import ru.mephi.info.model.User

interface UserService : UserDetailsService {
    fun findById(id: Int): User

    fun findByEmail(email: String) : User

    fun findByLogin(login: String) : User

    fun findAll() : List<User>

    fun save(user: User)

    fun updateById(id: Int, user: User)

    fun deleteById(id: Int)
}