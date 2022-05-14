package ru.mephi.info.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.mephi.info.model.Content

interface ContentDao: CrudRepository<Content, Int>{
    fun findContentsByTagsId(tags_id: Int): List<Content>

    fun findByTagsIdIsIn(tagsId: Set<Int>,pageable: Pageable): Set<Content>
}