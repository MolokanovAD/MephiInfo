package ru.mephi.info.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.mephi.info.model.Content
import ru.mephi.info.model.Tag

interface ContentDao: CrudRepository<Content, Int>{
    //fun findContentByTagsContains(tag: Set<Tag>, pageable: Pageable) : List<Content>

    //fun findContentByTagsWithin(tags: Set<Tag>, pageable: Pageable) : List<Content>
    fun findContentsByTagsId(tags_id: Int): List<Content>
}