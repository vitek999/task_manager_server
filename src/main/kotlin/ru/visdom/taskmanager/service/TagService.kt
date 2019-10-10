package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.model.Tag
import ru.visdom.taskmanager.repository.TagRepository

@Service
class TagService(private val tagRepository: TagRepository) {
    fun getAll(): Iterable<Tag> = tagRepository.findAllNative()

    fun getById(id: Long): Tag? = tagRepository.findByIdNative(id)

    fun deleteById(id: Long) = tagRepository.deleteByIdNative(id)

    fun insert(tag: Tag) = tagRepository.insertNative(tag.id, tag.name)

    fun update(tag: Tag) = tagRepository.updateNative(tag.id, tag.name)
}