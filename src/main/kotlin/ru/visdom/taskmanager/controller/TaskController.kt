package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.TaskNotFoundException
import ru.visdom.taskmanager.model.Task
import ru.visdom.taskmanager.service.TaskService

@RestController
@RequestMapping("/task")
class TaskController(private val taskService: TaskService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Task>> = try {
        ResponseEntity(taskService.getAll(), HttpStatus.OK)
    } catch (e: TaskNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Task> = try{
        ResponseEntity(taskService.getById(id), HttpStatus.OK)
    } catch (e: TaskNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try {
        ResponseEntity(taskService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody task: Task): ResponseEntity<Unit> =
            ResponseEntity(taskService.insert(task), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody task: Task): ResponseEntity<Unit> = try {
        ResponseEntity(taskService.update(task), HttpStatus.OK)
    } catch (e: TaskNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}