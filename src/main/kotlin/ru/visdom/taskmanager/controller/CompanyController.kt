package ru.visdom.taskmanager.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.model.Company
import ru.visdom.taskmanager.service.CompanyService

@RestController
@RequestMapping("/company")
class CompanyController(private val companyService: CompanyService){
    @GetMapping("/")
    fun getAll() = companyService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<Company> {
        return try {
            ResponseEntity(companyService.getById(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = companyService.deleteById(id)

    @PostMapping("/")
    fun insert(@RequestBody company: Company) = companyService.insert(company)

    @PutMapping("/")
    fun update(@RequestBody company: Company) = companyService.update(company)
}