package ru.mephi.info.controller

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import ru.mephi.info.model.Content
import ru.mephi.info.service.interfaces.ContentService

@RestController
@RequestMapping("/contents")
class ContentController(
    private val contentService: ContentService
) {
    //@GetMapping
    //fun getPage(@RequestBody tags: Set<Tag>, @RequestParam("page") pageIndex: Int):List<Content> = contentService.getContentsByTags(tags, pageIndex)

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int): Content = contentService.findById(id)

    @GetMapping("/by_tag/{id}")
    fun findByTagsId(@PathVariable id: Int) = contentService.findByTagsId(id)

    @GetMapping("/by_tags")
    fun findByTagsIdIsIn(
        @RequestBody ids: Set<Int>,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ) = contentService.findByTagsIdIsIn(ids,PageRequest.of(page,size))

    @PostMapping
    fun save(@RequestBody content: Content) = contentService.save(content)

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Int, @RequestBody Content: Content) = contentService.updateById(id,Content)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) = contentService.deleteById(id)
}