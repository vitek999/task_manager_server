package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.Role
import ru.visdom.taskmanager.repository.RoleRepository

@Service
class RoleService(private val roleRepository: RoleRepository) {
    fun getAll(): Iterable<Role> = roleRepository.findAllNative()

    fun getById(id: Long): Role? = roleRepository.findByIdNative(id)

    fun deleteById(id: Long) = roleRepository.deleteByIdNative(id)

    fun insert(role: Role) = roleRepository.insertNative(role.id, role.name)

    fun update(role: Role) = roleRepository.updateNative(role.id, role.name)
}