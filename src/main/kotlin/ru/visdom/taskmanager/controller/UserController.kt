package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.UserNotFoundException
import ru.visdom.taskmanager.model.User
import ru.visdom.taskmanager.service.UserService

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<User>> = try {
        ResponseEntity(userService.getAll(), HttpStatus.OK)
    } catch (e: UserNotFoundException){
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<User> =  try {
        ResponseEntity(userService.getById(id), HttpStatus.OK)
    } catch (e: UserNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try {
        ResponseEntity(userService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody user: User): ResponseEntity<Unit> =
            ResponseEntity(userService.insert(user), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody user: User): ResponseEntity<Unit> = try {
        ResponseEntity(userService.update(user), HttpStatus.OK)
    } catch (e: UserNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}