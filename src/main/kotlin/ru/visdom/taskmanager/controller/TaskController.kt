package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Task
import ru.visdom.taskmanager.service.TaskService

@RestController
@RequestMapping("/task")
class TaskController(private val taskService: TaskService){
    @GetMapping("/")
    fun getAll() = taskService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = taskService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = taskService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody task: Task) = taskService.insert(task)

    @PutMapping("/")
    fun update(@RequestBody task: Task) = taskService.update(task)
}