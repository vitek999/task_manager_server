package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Employee
import java.util.*

interface EmployeeRepository : CrudRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee ", nativeQuery = true)
    fun findAllNative() : List<Employee>

    @Query(value = "SELECT * FROM employee WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long) : Optional<Employee>

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employee WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee (id, user_id, subdivision_id, role_id) values " +
            "(:id, :userId, :subdivisionId, :roleId)", nativeQuery = true)
    fun insertNative(id: Long, userId: Long, subdivisionId: Long, roleId: Long)

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET user_id = :userId, subdivision_id = :subdivisionId, role_id = :roleId" +
            " WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, userId: Long, subdivisionId: Long, roleId: Long)
}