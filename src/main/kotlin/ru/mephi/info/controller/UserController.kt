package ru.mephi.info.controller

import org.springframework.web.bind.annotation.*
import ru.mephi.info.service.interfaces.UserService
import ru.mephi.info.model.User

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getAllUsers():List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id:Int):User = userService.getUser(id)

    @PostMapping
    fun createUser(@RequestBody user: User) = userService.createUser(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody user: User) = userService.updateUser(id,user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Int) = userService.deleteUser(id)
}