package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.EmployeeNotFoundException
import ru.visdom.taskmanager.model.Employee
import ru.visdom.taskmanager.repository.EmployeeRepository

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {
    fun getAll(): Iterable<Employee> {
        val data = employeeRepository.findAllNative()
        if (data.isEmpty())
            throw EmployeeNotFoundException("")
        return data
    }

    fun getById(id: Long): Employee = employeeRepository.findByIdNative(id).orElseThrow { EmployeeNotFoundException("") }

    fun deleteById(id: Long) = employeeRepository.deleteByIdNative(id)

    fun insert(employee: Employee) = employeeRepository.insertNative(employee.id, employee.userId, employee.subdivisionId, employee.roleId)

    fun update(employee: Employee) {
        if(employeeRepository.findByIdNative(employee.id).isEmpty)
            throw EmployeeNotFoundException("")
        employeeRepository.updateNative(employee.id, employee.userId, employee.subdivisionId, employee.roleId)
    }
}
