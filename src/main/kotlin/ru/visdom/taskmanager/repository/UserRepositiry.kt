package ru.visdom.taskmanager.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.visdom.taskmanager.model.User
import java.util.*

interface UserRepositiry : CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM user ", nativeQuery = true)
    fun findAllNative(): List<User>

    @Query(value = "SELECT * FROM user WHERE id = :id LIMIT 1", nativeQuery = true)
    fun findByIdNative(id: Long): Optional<User>

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE id = :id", nativeQuery = true)
    fun deleteByIdNative(id: Long)

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user (id, first_name, last_name, patronymic, email, password) values " +
            "(:id, :firstName, :lastName, :patronymic, :email, :password)", nativeQuery = true)
    fun insertNative(id: Long, firstName: String, lastName: String, patronymic: String, email: String, password: String)

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET first_name = :firstName, last_name = :lastName, patronymic = :patronymic, " +
            "email = :email, password = :password  WHERE id = :id", nativeQuery = true)
    fun updateNative(id: Long, firstName: String, lastName: String, patronymic: String, email: String, password: String)
}