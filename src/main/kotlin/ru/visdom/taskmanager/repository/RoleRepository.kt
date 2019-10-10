package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Role

interface RoleRepository : CrudRepository<Role, Long> {

    @Query(value = "SELECT * FROM role ", nativeQuery = true)
    fun findAllNative(): List<Role>

    @Query(value = "SELECT * FROM role WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long): Role?

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM role WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO role (id, name) values (:id, :name)", nativeQuery = true)
    fun insertNative(id: Long, name: String)

    @Modifying
    @Transactional
    @Query(value = "UPDATE role SET name = :name WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String)
}