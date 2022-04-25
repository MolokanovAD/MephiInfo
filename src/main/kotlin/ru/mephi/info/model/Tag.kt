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

//    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE],mappedBy = "tags")
//    val posts: Set<Content> = emptySet()
)