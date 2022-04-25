package ru.mephi.info.controller

import org.springframework.web.bind.annotation.*
import ru.mephi.info.model.Content
import ru.mephi.info.model.Tag
import ru.mephi.info.service.interfaces.ContentService

@RestController
@RequestMapping("/contents")
class ContentController(
    private val contentService: ContentService
) {
    //@GetMapping
    //fun getPage(@RequestBody tags: Set<Tag>, @RequestParam("page") pageIndex: Int):List<Content> = contentService.getContentsByTags(tags, pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable id:Int): Content = contentService.getContentById(id)

    @GetMapping("/by_tag/{id}")
    fun findContentsByTagsId(@PathVariable id: Int) = contentService.findContentByTagsId(id)

    @PostMapping
    fun create(@RequestBody content: Content) = contentService.createContent(content)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody Content: Content) = contentService.updateContent(id,Content)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = contentService.deleteContent(id)
}