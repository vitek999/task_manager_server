package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.StatusNotFoundException
import ru.visdom.taskmanager.model.Status
import ru.visdom.taskmanager.service.StatusService

@RestController
@RequestMapping("/status")
class StatusController(private val statusService: StatusService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Status>> = try {
        ResponseEntity(statusService.getAll(), HttpStatus.OK)
    } catch (e: StatusNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Status> = try {
        ResponseEntity(statusService.getById(id), HttpStatus.OK)
    } catch (e: StatusNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long):ResponseEntity<Unit> = try {
        ResponseEntity(statusService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody status: Status): ResponseEntity<Unit> =
            ResponseEntity(statusService.insert(status), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody status: Status): ResponseEntity<Unit> = try {
        ResponseEntity(statusService.update(status), HttpStatus.OK)
    } catch (e: StatusNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}