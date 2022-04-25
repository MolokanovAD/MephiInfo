package ru.mephi.info.service.implementations

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.core.userdetails.User as Usr
import org.springframework.stereotype.Service
import ru.mephi.info.model.User
import ru.mephi.info.repository.UserDao
import ru.mephi.info.service.interfaces.UserService

@Service
class UserServiceImpl(
    private val userDao: UserDao,
    private val passwordEncoder: PasswordEncoder
): UserService {
    override fun findById(id: Int): User = userDao.findById(id).orElseThrow()

    override fun findByEmail(email: String) = userDao.findByEmail(email)

    override fun findAll(): List<User> = userDao.findAll().toList()

    override fun findByLogin(login: String) = userDao.findByLogin(login)

    override fun save(user: User) {
        val newUser = User(user.id,user.email,passwordEncoder.encode(user.password),user.login)
        userDao.save(newUser)
    }

    override fun updateById(id: Int, user: User) {
        userDao.findById(id).ifPresent {
            val updatedUser = it.copy(
                email = user.email,
                password = user.password,
                login = user.login,
                fav_tags = user.fav_tags
            )
            userDao.save(updatedUser)
        }
    }

    override fun deleteById(id: Int) = userDao.deleteById(id)

    override fun loadUserByUsername(username: String?): UserDetails{
        val usr = findByLogin(username!!)
        return Usr(usr.login,usr.password, arrayListOf())
    }

}