package ru.visdom.taskmanager.controller

import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Employee
import ru.visdom.taskmanager.service.EmployeeService

@RestController
@RequestMapping("/employee")
class EmployeeController(private val employeeService: EmployeeService){
    @GetMapping("/")
    fun getAll() = employeeService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = employeeService.getById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = employeeService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody employee: Employee) = employeeService.insert(employee)

    @PutMapping("/")
    fun update(@RequestBody employee: Employee) = employeeService.update(employee)
}