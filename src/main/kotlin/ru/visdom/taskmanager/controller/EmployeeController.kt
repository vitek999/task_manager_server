package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.EmployeeNotFoundException
import ru.visdom.taskmanager.model.Employee
import ru.visdom.taskmanager.service.EmployeeService

@RestController
@RequestMapping("/employee")
class EmployeeController(private val employeeService: EmployeeService){
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Employee>> {
        return try {
            ResponseEntity(employeeService.getAll(), HttpStatus.OK)
        } catch (e: EmployeeNotFoundException) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Employee> = try {
            ResponseEntity(employeeService.getById(id), HttpStatus.OK)
        } catch (e: EmployeeNotFoundException) {
            ResponseEntity(HttpStatus.NO_CONTENT)
    }


    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> = try {
        ResponseEntity(employeeService.deleteById(id), HttpStatus.OK)
    } catch (e: DataIntegrityViolationException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/")
    fun insert(@RequestBody employee: Employee): ResponseEntity<Unit> =
            ResponseEntity(employeeService.insert(employee), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody employee: Employee): ResponseEntity<Unit> = try {
        ResponseEntity(employeeService.update(employee), HttpStatus.OK)
    } catch (e: EmployeeNotFoundException) {
        ResponseEntity(HttpStatus.CONFLICT)
    }
}