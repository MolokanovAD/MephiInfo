package ru.mephi.info.repository

import org.springframework.data.repository.CrudRepository
import ru.mephi.info.model.User

interface UserDao: CrudRepository<User, Int>{
    fun findByEmail(email: String) : User?
}