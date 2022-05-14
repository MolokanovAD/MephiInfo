package ru.mephi.info.repository

import org.springframework.data.repository.CrudRepository
import ru.mephi.info.model.Tag

interface TagDao: CrudRepository<Tag, Int>{
    fun findByName(name: String): Tag
}