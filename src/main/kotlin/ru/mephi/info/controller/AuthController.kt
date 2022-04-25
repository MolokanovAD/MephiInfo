package ru.mephi.info.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import ru.mephi.info.config.JwtTokenUtil
import ru.mephi.info.dto.LoginDto
import ru.mephi.info.dto.RegisterDto
import ru.mephi.info.model.User
import ru.mephi.info.service.interfaces.UserService


@RestController
@CrossOrigin
class JwtAuthenticationController(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenUtil: JwtTokenUtil,
    private val userDetailsService: UserService,
) {
//    @Autowired
//    private val authenticationManager: AuthenticationManager? = null
//
//    @Autowired
//    private val jwtTokenUtil: JwtTokenUtil? = null
//
//    @Autowired
//    private val userDetailsService: UserService? = null
    @PostMapping("/login")
    fun createAuthenticationToken(@RequestBody body: LoginDto): ResponseEntity<*> {
        authenticate(body.login, body.password)
        val userDetails = userDetailsService.loadUserByUsername(body.login)
        val token = jwtTokenUtil.generateToken(userDetails)
        return ResponseEntity.ok<Any>(token)
    }

    @PostMapping("/register")
    fun saveUser(@RequestBody user: RegisterDto): ResponseEntity<*>? {
        val user = User(0,user.email,user.password,user.login)
        userDetailsService.save(user)
        return ResponseEntity.ok("Success")
    }

    @Throws(Exception::class)
    private fun authenticate(username: String, password: String) {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}