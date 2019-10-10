package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.ImportanceLevel
import ru.visdom.taskmanager.service.ImportanceLevelService

@RestController
@RequestMapping("/importancelevel")
class ImportanceLevelController(private val importanceLevelService: ImportanceLevelService){
    @GetMapping("/")
    fun getAll() = importanceLevelService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = importanceLevelService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = importanceLevelService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody importanceLevel: ImportanceLevel) = importanceLevelService.insert(importanceLevel)

    @PutMapping("/")
    fun update(@RequestBody importanceLevel: ImportanceLevel) = importanceLevelService.update(importanceLevel)
}