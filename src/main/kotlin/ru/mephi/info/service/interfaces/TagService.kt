package ru.mephi.info.service.interfaces

import ru.mephi.info.model.Tag

interface TagService {
    fun getTag(id: Int): Tag

    fun getAllTags() : List<Tag>

    fun createTag(tag: Tag)

    fun updateTag(id: Int, tag: Tag)

    fun deleteTag(id: Int)
}