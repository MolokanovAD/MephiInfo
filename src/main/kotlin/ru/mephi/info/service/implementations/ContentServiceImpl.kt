package ru.mephi.info.service.implementations

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.mephi.info.repository.ContentDao
import ru.mephi.info.model.Content
import ru.mephi.info.service.interfaces.ContentService

@Service
class ContentServiceImpl(
    private val contentDao: ContentDao
): ContentService {
    override fun findById(id: Int): Content = contentDao.findById(id).orElseThrow()

    override fun findByTagsId(tagId: Int): List<Content> = contentDao.findContentsByTagsId(tagId)

    override fun findByTagsIdIsIn(tagsId: Set<Int>,pageable: Pageable): Set<Content> = contentDao.findByTagsIdIsIn(tagsId,pageable)

    //override fun getContentsByTags(tags: Set<Tag>, pageIndex: Int): List<Content> = contentDao.findContentByTagsContains(tags, PageRequest.of(pageIndex, 5))

    override fun save(content: Content) {
        val newContent = Content(content.id,content.type,content.date,content.text,content.title,content.author,content.tags)
        contentDao.save(newContent)
    }

    override fun updateById(id: Int, content: Content) {
        contentDao.findById(id).ifPresent {
            val updatedContent = it.copy(
                type = content.type,
                date = content.date,
                text = content.text,
                title = content.title,
                author = content.author
            )
            contentDao.save(updatedContent)
        }
    }

    override fun deleteById(id: Int) = contentDao.deleteById(id)

}