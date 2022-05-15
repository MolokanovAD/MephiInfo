package ru.mephi.info.service.interfaces

import org.springframework.data.domain.Pageable
import ru.mephi.info.model.Content

interface ContentService {
    fun findById(id: Int): Content

    fun findByTagsId(tagId: Int): List<Content>

    fun findByTagsIdIsInOrderByDateDesc(tagsId: Set<Int>,pageable: Pageable): Set<Content>

    fun save(content: Content)

    fun updateById(id: Int, content: Content)

    fun deleteById(id: Int)
}