package ru.mephi.info.service.interfaces

import ru.mephi.info.model.Group

interface GroupService {
    fun findById(id: Int): Group

    fun findAll() : List<Group>

    fun save(group: Group)

    fun updateById(id: Int, group: Group)

    fun deleteById(id: Int)
}