package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.Employee
import ru.visdom.taskmanager.repository.EmployeeRepository

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {
    fun getAll(): Iterable<Employee> = employeeRepository.findAllNative()

    fun getById(id: Long): Employee? = employeeRepository.findByIdNative(id)

    fun deleteById(id: Long) = employeeRepository.deleteByIdNative(id)

    fun insert(employee: Employee) = employeeRepository.insertNative(employee.id, employee.userId, employee.subdivisionId, employee.roleId)

    fun update(employee: Employee) = employeeRepository.updateNative(employee.id, employee.userId, employee.subdivisionId, employee.roleId)
}
