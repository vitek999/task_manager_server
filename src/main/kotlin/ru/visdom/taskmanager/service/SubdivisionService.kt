package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.SubdivisionNotFoundException
import ru.visdom.taskmanager.model.Subdivision
import ru.visdom.taskmanager.repository.SubdivisionRepository

@Service
class SubdivisionService(private val subdivisionRepository: SubdivisionRepository) {
    fun getAll(): Iterable<Subdivision>{
        val data = subdivisionRepository.findAllNative()
        if(data.isEmpty())
            throw SubdivisionNotFoundException("")
        return data
    }

    fun getById(id: Long): Subdivision? = subdivisionRepository.findByIdNative(id).orElseThrow { SubdivisionNotFoundException("") }

    fun deleteById(id: Long) = subdivisionRepository.deleteByIdNative(id)

    fun insert(subdivision: Subdivision) = subdivisionRepository.insertNative(subdivision.id, subdivision.name, subdivision.description, subdivision.companyId)

    fun update(subdivision: Subdivision) {
        if(subdivisionRepository.findByIdNative(subdivision.id).isEmpty)
            throw SubdivisionNotFoundException("")
        subdivisionRepository.updateNative(subdivision.id, subdivision.name, subdivision.description, subdivision.companyId)
    }
}