package ru.mephi.info.service.implementations

import org.springframework.stereotype.Service
import ru.mephi.info.repository.TagDao
import ru.mephi.info.model.Tag
import ru.mephi.info.service.interfaces.TagService

@Service
class TagServiceImpl(
    private val tagDao: TagDao
): TagService {
    override fun findById(id: Int): Tag = tagDao.findById(id).orElseThrow()

    override fun findByName(name: String): Tag? = tagDao.findByName(name)

    override fun findAll(): List<Tag> = tagDao.findAll().toList()

    override fun save(tag: Tag) {
        val newTag = Tag(tag.id,tag.name)
        tagDao.save(newTag)
    }

    override fun updateById(id: Int, tag: Tag) {
        tagDao.findById(id).ifPresent{
            val updatedTag = it.copy(
                name = tag.name
            )
            tagDao.save(updatedTag)
        }
    }

    override fun deleteById(id: Int) = tagDao.deleteById(id)
}