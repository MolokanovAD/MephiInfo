package ru.mephi.info.model

import javax.persistence.*

@Entity
@Table(name = "tags")
data class Tag(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "name")
    val name: String,

//    @ManyToMany(mappedBy = "fav_tags")
//    var users: Set<User> = emptySet(),

    @ManyToMany
    @JoinTable(
        name = "tag_content",
        joinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id") ],
        inverseJoinColumns = [JoinColumn(name = "content_id",referencedColumnName = "id")]
    )
    val posts: Set<Content> = emptySet()
)