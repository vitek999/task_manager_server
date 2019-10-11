package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.User
import ru.visdom.taskmanager.service.UserService

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService){
    @GetMapping("/")
    fun getAll() = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = userService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody user: User) = userService.insert(user)

    @PutMapping("/")
    fun update(@RequestBody user: User) = userService.update(user)
}