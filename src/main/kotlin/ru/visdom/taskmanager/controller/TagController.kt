package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Tag
import ru.visdom.taskmanager.service.TagService

@RestController
@RequestMapping("/tag")
class TagController(private val tagService: TagService){
    @GetMapping("/")
    fun getAll() = tagService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = tagService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = tagService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody tag: Tag) = tagService.insert(tag)

    @PutMapping("/")
    fun update(@RequestBody tag: Tag) = tagService.update(tag)
}