package ru.mephi.info.controller

import org.springframework.web.bind.annotation.*
import ru.mephi.info.config.JwtTokenUtil
import ru.mephi.info.service.interfaces.UserService
import ru.mephi.info.model.User

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val jwtTokenUtil: JwtTokenUtil
) {
    @GetMapping
    fun findAll():List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int):User = userService.findById(id)

    @GetMapping("/by_login")
    fun findByLogin(@RequestBody login: String):User = userService.findByLogin(login)

    @GetMapping("/by_token")
    fun findByToken(@RequestBody token: String):User = userService.findByLogin(jwtTokenUtil.getUsernameFromToken(token))

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Int, @RequestBody user: User) = userService.updateById(id,user)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) = userService.deleteById(id)
}