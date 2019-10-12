package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.TagNotFoundException
import ru.visdom.taskmanager.model.Tag
import ru.visdom.taskmanager.repository.TagRepository

@Service
class TagService(private val tagRepository: TagRepository) {
    fun getAll(): Iterable<Tag> {
        val data = tagRepository.findAllNative()
        if(data.isEmpty())
            throw TagNotFoundException("")
        return data
    }

    fun getById(id: Long): Tag = tagRepository.findByIdNative(id).orElseThrow { TagNotFoundException("") }

    fun deleteById(id: Long) = tagRepository.deleteByIdNative(id)

    fun insert(tag: Tag) = tagRepository.insertNative(tag.id, tag.name)

    fun update(tag: Tag){
        if(tagRepository.findByIdNative(tag.id).isEmpty)
            throw TagNotFoundException("")
        tagRepository.updateNative(tag.id, tag.name)
    }
}