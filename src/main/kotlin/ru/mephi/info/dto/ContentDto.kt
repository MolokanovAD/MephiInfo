package ru.mephi.info.dto

import ru.mephi.info.model.Tag

data class ContentDto(
    val id: Int? = null,
    val type: Int,
    val date: String,
    val text: String,
    val title: String,
    val author: String,
    var tags: Set<Tag> = emptySet()
)
