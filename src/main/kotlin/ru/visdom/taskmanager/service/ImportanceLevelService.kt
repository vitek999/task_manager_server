package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.ImportanceLevel
import ru.visdom.taskmanager.repository.ImportanceLevelRepository

@Service
class ImportanceLevelService(private val importanceLevelRepository: ImportanceLevelRepository) {
    fun getAll(): Iterable<ImportanceLevel> = importanceLevelRepository.findAllNative()

    fun getById(id: Long): ImportanceLevel? = importanceLevelRepository.findByIdNative(id)

    fun deleteById(id: Long) = importanceLevelRepository.deleteByIdNative(id)

    fun insert(importanceLevel: ImportanceLevel) = importanceLevelRepository.insertNative(importanceLevel.id, importanceLevel.name)

    fun update(importanceLevel: ImportanceLevel) = importanceLevelRepository.updateNative(importanceLevel.id, importanceLevel.name)
}