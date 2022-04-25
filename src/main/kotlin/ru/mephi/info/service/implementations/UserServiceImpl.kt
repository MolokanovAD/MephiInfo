package ru.mephi.info.service.implementations

import org.springframework.stereotype.Service
import ru.mephi.info.model.User
import ru.mephi.info.repository.UserDao
import ru.mephi.info.service.interfaces.UserService

@Service
class UserServiceImpl(
    private val userDao: UserDao
): UserService {
    override fun getUser(id: Int): User = userDao.findById(id).orElseThrow()

    override fun findByEmail(email: String) = userDao.findByEmail(email)

    override fun getAllUsers(): List<User> = userDao.findAll().toList()

    override fun findByLogin(login: String) = userDao.findByLogin(login)

    override fun createUser(user: User) {
        val newUser = User(user.login,user.email,user.password,)
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


}