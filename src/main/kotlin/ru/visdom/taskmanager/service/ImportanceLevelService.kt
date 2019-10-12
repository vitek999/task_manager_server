package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.ImportanceLevelNotFoundException
import ru.visdom.taskmanager.model.ImportanceLevel
import ru.visdom.taskmanager.repository.ImportanceLevelRepository

@Service
class ImportanceLevelService(private val importanceLevelRepository: ImportanceLevelRepository) {
    fun getAll(): Iterable<ImportanceLevel> {
        val data = importanceLevelRepository.findAllNative()
        if(data.isEmpty())
            throw ImportanceLevelNotFoundException("")
        return data
    }

    fun getById(id: Long): ImportanceLevel? = importanceLevelRepository.findByIdNative(id)
            .orElseThrow { ImportanceLevelNotFoundException("") }

    fun deleteById(id: Long) = importanceLevelRepository.deleteByIdNative(id)

    fun insert(importanceLevel: ImportanceLevel) = importanceLevelRepository.insertNative(importanceLevel.id, importanceLevel.name)

    fun update(importanceLevel: ImportanceLevel) {
        if(importanceLevelRepository.findByIdNative(importanceLevel.id).isEmpty)
            throw ImportanceLevelNotFoundException("")
        return importanceLevelRepository.updateNative(importanceLevel.id, importanceLevel.name)
    }
}