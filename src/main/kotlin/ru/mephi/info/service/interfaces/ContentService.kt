package ru.mephi.info.service.interfaces

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import ru.mephi.info.model.Content
import ru.mephi.info.model.Tag

interface ContentService {
    fun findById(id: Int): Content

    fun findByTagsId(tagId: Int): List<Content>

    fun findByTagsIdIsIn(tagsId: Set<Int>,pageable: Pageable): List<Content>

    fun save(content: Content)

    fun updateById(id: Int, content: Content)

    fun deleteById(id: Int)
}