package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Status
import ru.visdom.taskmanager.service.StatusService

@RestController
@RequestMapping("/status")
class StatusController(private val statusService: StatusService){
    @GetMapping("/")
    fun getAll() = statusService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = statusService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = statusService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody status: Status) = statusService.insert(status)

    @PutMapping("/")
    fun update(@RequestBody status: Status) = statusService.update(status)
}