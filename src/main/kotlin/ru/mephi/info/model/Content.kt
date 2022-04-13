package ru.mephi.info.model

import javax.persistence.*

@Entity
@Table(name = "contents")
data class Content(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "type")
    val type: Int,

    @Column(name = "date")
    val date: String,

    @Column(name = "text")
    val text: String,

    @Column(name = "title")
    val title: String,

    @Column(name = "author")
    val author: String,

    @ManyToMany(mappedBy = "posts")
    var tags: Set<Tag> = emptySet()
)
