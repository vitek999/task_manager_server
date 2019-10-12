package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.StatusNotFoundException
import ru.visdom.taskmanager.model.Status
import ru.visdom.taskmanager.repository.StatusRepository

@Service
class StatusService(private val statusRepository: StatusRepository) {
    fun getAll(): Iterable<Status>{
        val data = statusRepository.findAllNative()
        if(data.isEmpty())
            throw StatusNotFoundException("")
        return data
    }

    fun getById(id: Long): Status = statusRepository.findByIdNative(id).orElseThrow { StatusNotFoundException("") }

    fun deleteById(id: Long) = statusRepository.deleteByIdNative(id)

    fun insert(status: Status) = statusRepository.insertNative(status.id, status.name, status.description)

    fun update(status: Status) {
        if(statusRepository.findByIdNative(status.id).isEmpty)
            throw StatusNotFoundException("")
        statusRepository.updateNative(status.id, status.name, status.description)
    }
}