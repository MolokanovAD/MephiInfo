package ru.mephi.info.service.interfaces

import ru.mephi.info.model.Tag

interface TagService {
    fun findById(id: Int): Tag

    fun findByName(name: String): Tag?

    fun findAll() : List<Tag>

    fun save(tag: Tag)

    fun updateById(id: Int, tag: Tag)

    fun deleteById(id: Int)
}