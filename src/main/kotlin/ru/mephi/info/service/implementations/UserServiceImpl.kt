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
    private val encoder: PasswordEncoder
): UserService {
    override fun getUser(id: Int): User = userDao.findById(id).orElseThrow()

    override fun findByEmail(email: String) = userDao.findByEmail(email)

    override fun getAllUsers(): List<User> = userDao.findAll().toList()

    override fun findByLogin(login: String) = userDao.findByLogin(login)

    override fun createUser(user: User) {
        val newUser = User(user.login,user.email,encoder.encode(user.password))
        userDao.save(newUser)
    }



    override fun updateUser(id: Int, user: User) {
        userDao.findById(id).ifPresent {
//            val updatedUser = it.copy(
//                email = user.email,
//                password = user.password,
//                login = user.login,
//                fav_tags = user.fav_tags
//            )
            userDao.save(user)
        }
    }

    override fun deleteUser(id: Int) = userDao.deleteById(id)

//    override fun loadUserByUsername(username: String?): UserDetails{
//        val usr = findByEmail(username!!)
//        return Usr(usr.login,usr.password, arrayListOf())
//    }
    override fun loadUserByUsername(username: String?): UserDetails{
        val usr = findByLogin(username!!)
        return Usr(usr.login,usr.password, arrayListOf())
    }

}