package ru.visdom.taskmanager.service

import org.springframework.stereotype.Service
import ru.visdom.taskmanager.exception.CompanyNotFoundException
import ru.visdom.taskmanager.model.Company
import ru.visdom.taskmanager.repository.CompanyRepository

@Service
class CompanyService(private val companyRepository: CompanyRepository) {
    fun getAll(): Iterable<Company> {
        val data = companyRepository.findAllNative()
        if (data.isEmpty()) throw CompanyNotFoundException("")
        return data
    }

    fun getById(id: Long): Company = companyRepository.findByIdNative(id).orElseThrow { CompanyNotFoundException("") }

    fun deleteById(id: Long) = companyRepository.deleteByIdNative(id)

    fun insert(company: Company) = companyRepository.insertNative(company.id, company.name)

    fun update(company: Company) {
        companyRepository.findByIdNative(company.id).orElseThrow { CompanyNotFoundException("") }
        return companyRepository.updateNative(company.id, company.name)
    }
}