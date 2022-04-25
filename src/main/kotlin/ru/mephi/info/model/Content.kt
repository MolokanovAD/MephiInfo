package ru.mephi.info.model

import com.fasterxml.jackson.annotation.JsonIgnore
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "tag_content",
        joinColumns = [JoinColumn(name = "content_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    var tags: Set<Tag> = emptySet()
)
