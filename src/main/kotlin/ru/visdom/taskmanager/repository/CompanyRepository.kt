package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import ru.visdom.taskmanager.model.Company

interface CompanyRepository : CrudRepository<Company, Long> {

    @Query(value = "SELECT * FROM company ", nativeQuery = true)
    fun findAllNative() : List<Company>

    @Query(value = "SELECT * FROM company WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long) : Company?

    @Query(value = "DELETE FROM company WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Query(value = "INSERT INTO company (id, name) values (item.id, item.name)", nativeQuery = true)
    fun insertNative(item: Company)

    @Query(value = "UPDATE company SET name = item.name WHERE id = item.id", nativeQuery = true)
    fun updateNative(item: Company)
}