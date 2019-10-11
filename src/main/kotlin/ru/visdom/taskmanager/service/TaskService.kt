package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.Task
import ru.visdom.taskmanager.repository.TaskRepository

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun getAll(): Iterable<Task> = taskRepository.findAllNative()

    fun getById(id: Long): Task? = taskRepository.findByIdNative(id)

    fun deleteById(id: Long) = taskRepository.deleteByIdNative(id)

    fun insert(task: Task) = taskRepository.insertNative(task.id, task.name, task.description, task.startDate, task.endDate,
            task.statusId, task.importanceLevelId, task.employeeId)

    fun update(task: Task) = taskRepository.updateNative(task.id, task.name, task.description, task.startDate, task.endDate,
            task.statusId, task.importanceLevelId, task.employeeId)
}