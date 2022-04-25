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
    fun findAll():List<Tag> = tagService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int): Tag = tagService.findById(id)

    @PostMapping
    fun save(@RequestBody Tag: Tag) = tagService.save(Tag)

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Int, @RequestBody Tag: Tag) = tagService.updateById(id,Tag)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) = tagService.deleteById(id)
}