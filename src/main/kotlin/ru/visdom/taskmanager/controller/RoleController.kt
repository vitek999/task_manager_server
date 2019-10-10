package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Role
import ru.visdom.taskmanager.service.RoleService

@RestController
@RequestMapping("/role")
class RoleController(private val roleService: RoleService){
    @GetMapping("/")
    fun getAll() = roleService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = roleService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = roleService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody role: Role) = roleService.insert(role)

    @PutMapping("/")
    fun update(@RequestBody role: Role) = roleService.update(role)
}