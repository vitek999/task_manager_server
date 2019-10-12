package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.SubdivisionNotFoundException
import ru.visdom.taskmanager.model.Subdivision
import ru.visdom.taskmanager.service.SubdivisionService

@RestController
@RequestMapping("/subdivision")
class SubdivisionController(private val subdivisionService: SubdivisionService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Subdivision>> = try {
        ResponseEntity(subdivisionService.getAll(), HttpStatus.OK)
    } catch (e: SubdivisionNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Subdivision> = try {
        ResponseEntity(subdivisionService.getById(id), HttpStatus.OK)
    } catch (e: SubdivisionNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try {
        ResponseEntity(subdivisionService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody subdivision: Subdivision): ResponseEntity<Unit> =
            ResponseEntity(subdivisionService.insert(subdivision), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody subdivision: Subdivision):ResponseEntity<Unit> = try {
        ResponseEntity(subdivisionService.update(subdivision), HttpStatus.OK)
    } catch (e: SubdivisionNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}