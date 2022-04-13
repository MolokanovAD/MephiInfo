package ru.mephi.info.model

import javax.persistence.*

@Entity
@Table(name = "groups")
data class Group(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "name")
    val name: String,
)