package ru.mephi.info.service.implementations

import org.springframework.stereotype.Service
import ru.mephi.info.repository.GroupDao
import ru.mephi.info.model.Group
import ru.mephi.info.service.interfaces.GroupService

@Service
class GroupServiceImpl(
    private val groupDao: GroupDao
): GroupService {
    override fun findById(id: Int): Group = groupDao.findById(id).orElseThrow()

    override fun findAll(): List<Group> = groupDao.findAll().toList()

    override fun save(group: Group) {
        val newGroup = Group(group.id,group.name)
        groupDao.save(newGroup)
    }

    override fun updateById(id: Int, group: Group) {
        groupDao.findById(id).ifPresent {
            val updatedGroup = it.copy(
                name = group.name
            )
            groupDao.save(updatedGroup)
        }
    }

    override fun deleteById(id: Int) = groupDao.deleteById(id)

}