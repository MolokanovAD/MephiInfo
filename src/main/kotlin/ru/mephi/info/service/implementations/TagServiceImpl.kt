package ru.mephi.info.service.implementations

import org.springframework.stereotype.Service
import ru.mephi.info.repository.TagDao
import ru.mephi.info.model.Tag
import ru.mephi.info.service.interfaces.TagService

@Service
class TagServiceImpl(
    private val tagDao: TagDao
): TagService {
    override fun getTag(id: Int): Tag = tagDao.findById(id).orElseThrow()

    override fun getAllTags(): List<Tag> = tagDao.findAll().toList()

    override fun createTag(tag: Tag) {
        val newTag = Tag(tag.id,tag.name)
        tagDao.save(newTag)
    }

    override fun updateTag(id: Int, tag: Tag) {
        tagDao.findById(id).ifPresent{
            val updatedTag = it.copy(
                name = tag.name
            )
            tagDao.save(updatedTag)
        }
    }

    override fun deleteTag(id: Int) = tagDao.deleteById(id)
}