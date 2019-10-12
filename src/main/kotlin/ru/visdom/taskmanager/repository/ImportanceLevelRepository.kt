package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.ImportanceLevel
import java.util.*

interface ImportanceLevelRepository : CrudRepository<ImportanceLevel, Long> {

    @Query(value = "SELECT * FROM importancelevel ", nativeQuery = true)
    fun findAllNative() : List<ImportanceLevel>

    @Query(value = "SELECT * FROM importancelevel WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long) : Optional<ImportanceLevel>

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM importancelevel WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO importancelevel (id, name) values (:id, :name)", nativeQuery = true)
    fun insertNative(id: Long, name: String)

    @Modifying
    @Transactional
    @Query(value = "UPDATE importancelevel SET name = :name WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String)
}