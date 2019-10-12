package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Task
import java.time.LocalDateTime
import java.util.*

interface TaskRepository : CrudRepository<Task, Long> {

    @Query(value = "SELECT * FROM task ", nativeQuery = true)
    fun findAllNative(): List<Task>

    @Query(value = "SELECT * FROM task WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long): Optional<Task>

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM task WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO task (id, name, decription, start_date, end_date, status_id, importancelevel_id," +
            "employee_id) values (:id, :name, :description, :startDate, :endDate, :statusId, :importanceLevelId, :employeeId )", nativeQuery = true)
    fun insertNative(id: Long, name: String, description: String, startDate: LocalDateTime, endDate: LocalDateTime, statusId: Long,
                     importanceLevelId: Long, employeeId: Long)

    @Modifying
    @Transactional
    @Query(value = "UPDATE task SET name = :name, decription = :description, start_date = :startDate, end_date = :endDate, " +
            "status_id = :statusId, importancelevel_id = :importanceLevelId, employee_id = :employeeId WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String, description: String, startDate: LocalDateTime, endDate: LocalDateTime, statusId: Long,
                     importanceLevelId: Long, employeeId: Long)
}