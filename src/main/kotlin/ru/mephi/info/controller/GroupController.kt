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
    fun getAllGroups():List<Group> = GroupService.getAllGroups()

    @GetMapping("/{id}")
    fun getGroup(@PathVariable id:Int): Group = GroupService.getGroup(id)

    @PostMapping
    fun createGroup(@RequestBody Group: Group) = GroupService.createGroup(Group)

    @PutMapping("/{id}")
    fun updateGroup(@PathVariable id: Int, @RequestBody Group: Group) = GroupService.updateGroup(id,Group)

    @DeleteMapping("/{id}")
    fun deleteGroup(@PathVariable id: Int) = GroupService.deleteGroup(id)
}