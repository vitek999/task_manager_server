package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.RoleNotFoundException
import ru.visdom.taskmanager.model.Role
import ru.visdom.taskmanager.repository.RoleRepository
@Service
class RoleService(private val roleRepository: RoleRepository) {
    fun getAll(): Iterable<Role>{
        val data = roleRepository.findAllNative()
        if(data.isEmpty())
            throw RoleNotFoundException("")
        return data
    }

    fun getById(id: Long): Role = roleRepository.findByIdNative(id).orElseThrow { RoleNotFoundException("") }

    fun deleteById(id: Long) = roleRepository.deleteByIdNative(id)

    fun insert(role: Role) = roleRepository.insertNative(role.id, role.name)

    fun update(role: Role) {
        if(roleRepository.findByIdNative(role.id).isEmpty)
            throw RoleNotFoundException("")
        roleRepository.updateNative(role.id, role.name)
    }
}