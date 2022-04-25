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
    fun findAll():List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int):User = userService.findById(id)

    @PostMapping
    fun save(@RequestBody user: User) = userService.save(user)

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Int, @RequestBody user: User) = userService.updateById(id,user)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) = userService.deleteById(id)
}