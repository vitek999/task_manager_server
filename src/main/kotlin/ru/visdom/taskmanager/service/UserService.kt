package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.User
import ru.visdom.taskmanager.repository.UserRepositiry

@Service
class UserService(private val userRepositiry: UserRepositiry) {
    fun getAll(): Iterable<User> = userRepositiry.findAllNative()

    fun getById(id: Long): User? = userRepositiry.findByIdNative(id)

    fun deleteById(id: Long) = userRepositiry.deleteByIdNative(id)

    fun insert(user: User) = userRepositiry.insertNative(user.id, user.firstName, user.lastName, user.patronymic, user.email, user.password)

    fun update(user: User) = userRepositiry.updateNative(user.id, user.firstName, user.lastName, user.patronymic, user.email, user.password)
}