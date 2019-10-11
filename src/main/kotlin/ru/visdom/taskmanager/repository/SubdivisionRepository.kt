package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.Subdivision

interface SubdivisionRepository : CrudRepository<Subdivision, Long> {
    @Query(value = "SELECT * FROM subdivision ", nativeQuery = true)
    fun findAllNative(): List<Subdivision>

    @Query(value = "SELECT * FROM subdivision WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long): Subdivision?

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM subdivision WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO subdivision (id, name, desciption, company_id) values " +
            "(:id, :name, :description, :companyId)", nativeQuery = true)
    fun insertNative(id: Long, name: String, description: String, companyId: Long)

    @Modifying
    @Transactional
    @Query(value = "UPDATE subdivision SET name = :name, desciption = :description, company_id = :companyId" +
            "  WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, name: String, description: String, companyId: Long)
}