package ru.mephi.info.controller

import org.springframework.web.bind.annotation.*
import ru.mephi.info.model.Tag
import ru.mephi.info.service.interfaces.TagService

@RestController
@RequestMapping("/tags")
class TagController(
    private val tagService: TagService
) {
    @GetMapping
    fun getAllTags():List<Tag> = tagService.getAllTags()

    @GetMapping("/{id}")
    fun getTag(@PathVariable id:Int): Tag = tagService.getTag(id)

    @PostMapping
    fun createTag(@RequestBody Tag: Tag) = tagService.createTag(Tag)

    @PutMapping("/{id}")
    fun updateTag(@PathVariable id: Int, @RequestBody Tag: Tag) = tagService.updateTag(id,Tag)

    @DeleteMapping("/{id}")
    fun deleteTag(@PathVariable id: Int) = tagService.deleteTag(id)
}