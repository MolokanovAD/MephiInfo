package ru.mephi.info.service.interfaces

import ru.mephi.info.model.Group

interface GroupService {
    fun getGroup(id: Int): Group

    fun getAllGroups() : List<Group>

    fun createGroup(group: Group)

    fun updateGroup(id: Int, group: Group)

    fun deleteGroup(id: Int)
}