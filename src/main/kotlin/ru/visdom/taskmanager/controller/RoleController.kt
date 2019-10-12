package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.RoleNotFoundException
import ru.visdom.taskmanager.model.Role
import ru.visdom.taskmanager.service.RoleService

@RestController
@RequestMapping("/role")
class RoleController(private val roleService: RoleService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Role>> = try {
        ResponseEntity(roleService.getAll(), HttpStatus.OK)
    } catch (e: RoleNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Role> = try {
        ResponseEntity(roleService.getById(id), HttpStatus.OK)
    } catch (e: RoleNotFoundException) {
        ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try{
        ResponseEntity(roleService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody role: Role): ResponseEntity<Unit> =
            ResponseEntity(roleService.insert(role), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody role: Role): ResponseEntity<Unit> = try{
        ResponseEntity(roleService.update(role), HttpStatus.OK)
    } catch (e: RoleNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}