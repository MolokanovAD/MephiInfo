package ru.mephi.info.controller

import org.springframework.web.bind.annotation.*
import ru.mephi.info.model.Group
import ru.mephi.info.service.interfaces.GroupService

@RestController
@RequestMapping("/groups")
class GroupController(
    private val GroupService: GroupService
) {
    @GetMapping
    fun findAll():List<Group> = GroupService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int): Group = GroupService.findById(id)

    @PostMapping
    fun save(@RequestBody Group: Group) = GroupService.save(Group)

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Int, @RequestBody Group: Group) = GroupService.updateById(id,Group)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) = GroupService.deleteById(id)
}