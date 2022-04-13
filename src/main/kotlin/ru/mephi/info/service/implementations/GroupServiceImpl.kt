package ru.mephi.info.service.implementations

import org.springframework.stereotype.Service
import ru.mephi.info.repository.GroupDao
import ru.mephi.info.model.Group
import ru.mephi.info.service.interfaces.GroupService

@Service
class GroupServiceImpl(
    private val groupDao: GroupDao
): GroupService {
    override fun getGroup(id: Int): Group = groupDao.findById(id).orElseThrow()

    override fun getAllGroups(): List<Group> = groupDao.findAll().toList()

    override fun createGroup(group: Group) {
        val newGroup = Group(group.id,group.name)
        groupDao.save(newGroup)
    }

    override fun updateGroup(id: Int, group: Group) {
        groupDao.findById(id).ifPresent {
            val updatedGroup = it.copy(
                name = group.name
            )
            groupDao.save(updatedGroup)
        }
    }

    override fun deleteGroup(id: Int) = groupDao.deleteById(id)

}