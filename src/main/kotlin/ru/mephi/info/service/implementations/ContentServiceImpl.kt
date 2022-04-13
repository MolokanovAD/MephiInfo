package ru.mephi.info.service.implementations

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.mephi.info.repository.ContentDao
import ru.mephi.info.model.Content
import ru.mephi.info.model.Tag
import ru.mephi.info.service.interfaces.ContentService

@Service
class ContentServiceImpl(
    private val contentDao: ContentDao
): ContentService {
    override fun getContentById(id: Int): Content = contentDao.findById(id).orElseThrow()

    override fun getContentsByTags(tags: Set<Tag>, pageIndex: Int): List<Content> = contentDao.findContentByTagsContains(tags, PageRequest.of(pageIndex, 5))

    override fun createContent(content: Content) {
        val newContent = Content(content.id,content.type,content.date,content.text,content.title,content.author)
        contentDao.save(newContent)
    }

    override fun updateContent(id: Int, content: Content) {
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

    override fun deleteContent(id: Int) = contentDao.deleteById(id)

}