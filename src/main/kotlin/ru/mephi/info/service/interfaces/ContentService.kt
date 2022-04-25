package ru.mephi.info.service.interfaces

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import ru.mephi.info.model.Content
import ru.mephi.info.model.Tag

interface ContentService {
    fun getContentById(id: Int): Content

    //fun getContentsByTags(tags: Set<Tag>, pageIndex: Int) : List<Content>

    fun findContentByTagsId(tagId: Int): List<Content>

    fun createContent(content: Content)

    fun updateContent(id: Int, content: Content)

    fun deleteContent(id: Int)
}