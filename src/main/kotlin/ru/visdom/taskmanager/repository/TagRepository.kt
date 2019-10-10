package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Tag

interface TagRepository : CrudRepository<Tag, Long> {

    @Query(value = "SELECT * FROM tag ", nativeQuery = true)
    fun findAllNative(): List<Tag>

    @Query(value = "SELECT * FROM tag WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long): Tag?

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tag WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tag (id, name) values (:id, :name)", nativeQuery = true)
    fun insertNative(id: Long, name: String)

    @Modifying
    @Transactional
    @Query(value = "UPDATE tag SET name = :name WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String)
}