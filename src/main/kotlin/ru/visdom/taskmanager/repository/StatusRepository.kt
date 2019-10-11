package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Status

interface StatusRepository : CrudRepository<Status, Long> {

    @Query(value = "SELECT * FROM status ", nativeQuery = true)
    fun findAllNative(): List<Status>

    @Query(value = "SELECT * FROM status WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long): Status?

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM status WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO status (id, name, description) values (:id, :name, :description)", nativeQuery = true)
    fun insertNative(id: Long, name: String, description: String)

    @Modifying
    @Transactional
    @Query(value = "UPDATE status SET name = :name , description = :description WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String, description: String)
}