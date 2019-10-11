package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Subdivision
import ru.visdom.taskmanager.service.SubdivisionService

@RestController
@RequestMapping("/subdivision")
class SubdivisionController(private val subdivisionService: SubdivisionService){
    @GetMapping("/")
    fun getAll() = subdivisionService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = subdivisionService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = subdivisionService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody subdivision: Subdivision) = subdivisionService.insert(subdivision)

    @PutMapping("/")
    fun update(@RequestBody subdivision: Subdivision) = subdivisionService.update(subdivision)
}