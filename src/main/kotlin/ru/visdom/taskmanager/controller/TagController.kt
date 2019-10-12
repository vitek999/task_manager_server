package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.TagNotFoundException
import ru.visdom.taskmanager.model.Tag
import ru.visdom.taskmanager.service.TagService

@RestController
@RequestMapping("/tag")
class TagController(private val tagService: TagService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Tag>> = try {
        ResponseEntity(tagService.getAll(), HttpStatus.OK)
    } catch (e: TagNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Tag> = try {
        ResponseEntity(tagService.getById(id), HttpStatus.OK)
    } catch (e: TagNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try {
        ResponseEntity(tagService.deleteById(id), HttpStatus.OK)
    }catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody tag: Tag): ResponseEntity<Unit> = ResponseEntity(tagService.insert(tag), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody tag: Tag): ResponseEntity<Unit> = try{
        ResponseEntity(tagService.update(tag), HttpStatus.OK)
    } catch (e: TagNotFoundException){
        ResponseEntity(HttpStatus.CONFLICT)
    }
}