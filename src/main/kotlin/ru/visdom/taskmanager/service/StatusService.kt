package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.Status
import ru.visdom.taskmanager.repository.StatusRepository

@Service
class StatusService(private val statusRepository: StatusRepository) {
    fun getAll(): Iterable<Status> = statusRepository.findAllNative()

    fun getById(id: Long): Status? = statusRepository.findByIdNative(id)

    fun deleteById(id: Long) = statusRepository.deleteByIdNative(id)

    fun insert(status: Status) = statusRepository.insertNative(status.id, status.name, status.description)

    fun update(status: Status) = statusRepository.updateNative(status.id, status.name, status.description)
}