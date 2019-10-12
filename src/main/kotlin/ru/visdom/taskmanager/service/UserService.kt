package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.UserNotFoundException
import ru.visdom.taskmanager.model.User
import ru.visdom.taskmanager.repository.UserRepositiry

@Service
class UserService(private val userRepositiry: UserRepositiry) {
    fun getAll(): Iterable<User> {
        val data = userRepositiry.findAllNative()
        if(data.isEmpty()) throw UserNotFoundException("")
        return data
    }

    fun getById(id: Long): User = userRepositiry.findByIdNative(id).orElseThrow { UserNotFoundException("") }

    fun deleteById(id: Long) = userRepositiry.deleteByIdNative(id)

    fun insert(user: User) = userRepositiry.insertNative(user.id, user.firstName, user.lastName, user.patronymic, user.email, user.password)

    fun update(user: User) {
        if(userRepositiry.findByIdNative(user.id).isEmpty) throw UserNotFoundException("")
        userRepositiry.updateNative(user.id, user.firstName, user.lastName, user.patronymic, user.email, user.password)
    }
}