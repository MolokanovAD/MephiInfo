package ru.mephi.info.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import ru.mephi.info.config.JwtTokenUtil
import ru.mephi.info.dto.JwtToken
import ru.mephi.info.dto.LoginDto
import ru.mephi.info.dto.RegisterDto
import ru.mephi.info.model.User
import ru.mephi.info.service.interfaces.UserService
import javax.servlet.http.HttpServletResponse




@RestController
//@RequestMapping("api")
class AuthController(private val userService: UserService, private val jwtTokenUtil: JwtTokenUtil) {
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @PostMapping("register")
    fun register(@RequestBody body: RegisterDto): ResponseEntity<Any> {
        val pass = passwordEncoder.encode(body.password)
        println("PASS $pass")
        val user = User(body.login,body.email,pass)
        println("aftr ${user.password}")
        userService.createUser(user)
        return ResponseEntity.ok("Success")
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDto, response: HttpServletResponse): ResponseEntity<Any> {
        val user = userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body("user not found!")
        println("From BD ${user.password}")
        println("Request body ${body.password}")
        if (passwordEncoder.matches(body.password,user.password)) {
            return ResponseEntity.badRequest().body("invalid password!")
        }

        //val issuer = user.id.toString()
        val token = jwtTokenUtil.generateToken(user);

        return ResponseEntity.ok(JwtToken(token))
    }

//    @GetMapping("user")
//    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
//        try {
//            if (jwt == null) {
//                return ResponseEntity.status(401).body("unauthenticated")
//            }
//
//            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
//
//            return ResponseEntity.ok(this.userService.getUser(body.issuer.toInt()))
//        } catch (e: Exception) {
//            return ResponseEntity.status(401).body("unauthenticated")
//        }
//    }

//    @PostMapping("logout")
//    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
//        val cookie = Cookie("jwt", "")
//        cookie.maxAge = 0
//
//        response.addCookie(cookie)
//
//        return ResponseEntity.ok("success")
//    }
}