package ru.mephi.info.model

import javax.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "lastname")
    val lastname: String,

    @Column(name = "group_id")
    val groupId: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "login")
    val login: String,

    @ManyToMany
    @JoinTable(
        name = "favourite_tags",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id") ],
        inverseJoinColumns = [JoinColumn(name = "tag_id",referencedColumnName = "id")]
    )
    val fav_tags: Set<Tag> = emptySet()
) {
    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}