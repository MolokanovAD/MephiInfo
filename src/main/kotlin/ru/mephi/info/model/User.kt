package ru.mephi.info.model
import ru.mephi.info.config.JwtTokenUtil
import javax.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")

    val password: String,

    @Column(name = "login")
    val login: String,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "favourite_tags",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id") ],
        inverseJoinColumns = [JoinColumn(name = "tag_id",referencedColumnName = "id")]
    )
    val fav_tags: Set<Tag> = emptySet()
) {

    fun getLogin(token: String): String = JwtTokenUtil().getUsernameFromToken(token)
    fun favTagsIds() = fav_tags.map { it -> it.id }
}