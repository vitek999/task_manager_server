package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.ImportanceLevelNotFoundException
import ru.visdom.taskmanager.model.ImportanceLevel
import ru.visdom.taskmanager.service.ImportanceLevelService

@RestController
@RequestMapping("/importancelevel")
class ImportanceLevelController(private val importanceLevelService: ImportanceLevelService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<ImportanceLevel>> = try {
        ResponseEntity(importanceLevelService.getAll(), HttpStatus.OK)
    } catch (e: ImportanceLevelNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ImportanceLevel> = try {
        ResponseEntity(importanceLevelService.getById(id), HttpStatus.OK)
    } catch (e: ImportanceLevelNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try {
        ResponseEntity(importanceLevelService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody importanceLevel: ImportanceLevel): ResponseEntity<Unit> =
            ResponseEntity(importanceLevelService.insert(importanceLevel), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody importanceLevel: ImportanceLevel): ResponseEntity<Unit> =  try {
        ResponseEntity(importanceLevelService.update(importanceLevel), HttpStatus.OK)
    } catch (e: ImportanceLevelNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}