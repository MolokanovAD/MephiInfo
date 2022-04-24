package ru.mephi.info.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//@Entity
//@Table(name = "users")
//data class User(
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Int = 0,
//
//    @Column(name = "email")
//    val email: String,
//
//    @Column(name = "password")
//    val password: String,
//
//    @Column(name = "login")
//    val login: String,
//
//    @Column(name = "name")
//    val name: String?,
//
//    @Column(name = "lastname")
//    val lastname: String?,
//
//    @Column(name = "group_id")
//    val groupId: String?,
//
//    @ManyToMany
//    @JoinTable(
//        name = "favourite_tags",
//        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id") ],
//        inverseJoinColumns = [JoinColumn(name = "tag_id",referencedColumnName = "id")]
//    )
//    val fav_tags: Set<Tag> = emptySet()
//) {
//
//    fun comparePassword(password: String): Boolean {
//        return BCryptPasswordEncoder().matches(password, this.password)
//    }
//}



@Entity
@Table(name = "users")
class User( p_login: String, p_email: String, p_password: String){
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0

    @Column(name = "email")
    val email: String = p_email

    @Column(name = "password")
    val password: String = BCryptPasswordEncoder().encode(p_password)
    //val password: String = p_password

    @Column(name = "login")
    val login: String = p_login
//
//    @Column(name = "name")
//    val name: String?,
//
//    @Column(name = "lastname")
//    val lastname: String?,
//
//    @Column(name = "group_id")
//    val groupId: String?,

    @ManyToMany
    @JoinTable(
        name = "favourite_tags",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id") ],
        inverseJoinColumns = [JoinColumn(name = "tag_id",referencedColumnName = "id")]
    )
    val fav_tags: Set<Tag> = emptySet()

    fun comparePassword(pass: String): Boolean {
        println("--ARGUMENT--" + pass)
        println("--FIELD--" + password)
        return BCryptPasswordEncoder().matches(pass, this.password)
        //return pass == password
    }
}



//@Entity
//@Table(name = "users")
//class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Int = 0
//
//    @Column
//    var login = ""
//
//    @Column(unique = true)
//    var email = ""
//
//    @Column
//    var password = ""
//        @JsonIgnore
//        get() = field
//        set(value) {
//            val passwordEncoder = BCryptPasswordEncoder()
//            field = passwordEncoder.encode(value)
//        }
//
//    fun comparePassword(password: String): Boolean {
//        return BCryptPasswordEncoder().matches(password, this.password)
//    }
//}