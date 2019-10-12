package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.TaskNotFoundException
import ru.visdom.taskmanager.model.Task
import ru.visdom.taskmanager.repository.TaskRepository

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun getAll(): Iterable<Task> {
        val data = taskRepository.findAllNative()
        if(data.isEmpty())
            throw TaskNotFoundException("")
        return data
    }

    fun getById(id: Long): Task = taskRepository.findByIdNative(id).orElseThrow { TaskNotFoundException("") }

    fun deleteById(id: Long) = taskRepository.deleteByIdNative(id)

    fun insert(task: Task) = taskRepository.insertNative(task.id, task.name, task.description, task.startDate, task.endDate,
            task.statusId, task.importanceLevelId, task.employeeId)

    fun update(task: Task) {
        if(taskRepository.findByIdNative(task.id).isEmpty)
            throw TaskNotFoundException("")
        taskRepository.updateNative(task.id, task.name, task.description, task.startDate, task.endDate,
                task.statusId, task.importanceLevelId, task.employeeId)
    }
}