package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Company

interface CompanyRepository : CrudRepository<Company, Long> {

    @Query(value = "SELECT * FROM company ", nativeQuery = true)
    fun findAllNative() : List<Company>

    @Query(value = "SELECT * FROM company WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long) : Company?

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM company WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO company (id, name) values (:id, :name)", nativeQuery = true)
    fun insertNative(id: Long, name: String)

    @Modifying
    @Transactional
    @Query(value = "UPDATE company SET name = :name WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String)
}